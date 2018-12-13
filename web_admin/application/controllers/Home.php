<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Home extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		//Do your magic here
		$this->load->database();
		$this->load->helper('url','form');
		$this->load->library('form_validation');
		$this->load->model('Ruangan_model');
		$this->load->model('Gedung_model');
        $this->load->model('User_model');
        if($this->session->userdata('status') != "login"){
            redirect('Main', 'refresh');
        }
	}

	public function index()
	{
		$this->load->view('admin/ruangan/home');	
	}

	public function insert_ruangan()
	{
	
        $this->form_validation->set_rules('kd_ruangan', 'kd_ruangan', 'trim|required|min_length[3]|max_length[10]');
        $this->form_validation->set_rules('nm_ruangan', 'nm_ruangan', 'trim|required|max_length[50]');
        $this->form_validation->set_rules('kd_gedung', 'kd_gedung', 'trim|required');
        $this->form_validation->set_rules('latitude', 'latitude', 'trim|required');
        $this->form_validation->set_rules('longitude', 'longitude', 'trim|required');
        
        // load model
        $this->load->model('Ruangan_model');
        $this->load->model('Gedung_model');
        $data['dropdown'] = $this->Gedung_model->getKd();

        if($this->form_validation->run()==FALSE)
        {
            $this->load->view('admin/ruangan/add',$data);
        }
        else
        {
        	// $kd_ruangan					= 'kd_ruangan';
        	$directory					= "../RestApi/application/upload_ruangan/";
        	$new_name					= $_FILES["userfile"]['name'].".png";
        	// $change						= "application/upload_ruangan".'kd_ruangan'($new_name, PATHINFO_EXTENSION);
        	// $photoName 					= .".png";
        	// $save_path					= "application/upload_user/".$new_name;
        	// $config['uploadfile']		= $save_path;
            $config['upload_path']      = $directory;
            $config['allowed_types']	= 'gif|jpg|png|jpeg';
            $config['max_size']         = '1000000000';
            $config['max_width']        = '1680';
            $config['max_height']       = '1024';
            // $config['file_name'] 		= $new_name;

            $this->load->library('upload', $config);
            
            if(! $this->upload->do_upload('userfile'))
            {
                $error = array('error' => $this->upload->display_errors());
                $this->load->view('admin/ruangan/add', $error);
               // print_r($error);
            }
            else
            {
                $this->Ruangan_model->insertRuangan();
                $this->load->view('admin/ruangan/add_sukses');
            }
        }    
	}

	public function update_ruangan($kd_ruangan)
	{
		$this->form_validation->set_rules('kd_ruangan', 'kd_ruangan', 'trim|required|min_length[3]|max_length[10]');
        $this->form_validation->set_rules('nm_ruangan', 'nm_ruangan', 'trim|required|max_length[50]');
        $this->form_validation->set_rules('kd_gedung', 'kd_gedung', 'trim|required');
        $this->form_validation->set_rules('latitude', 'latitude', 'trim|required');
        $this->form_validation->set_rules('longitude', 'longitude', 'trim|required');
        
        // load model
        $this->load->model('Ruangan_model');
        $this->load->model('Gedung_model');
        $data['ruangan_up'] = $this->Ruangan_model->getRuanganUp($kd_ruangan);
        $data['dropdown'] = $this->Gedung_model->getKd();

        if($this->form_validation->run()==FALSE)
        {
            $this->load->view('admin/ruangan/update',$data);
        }
        else
        {
        	// $kd_ruangan					= 'kd_ruangan';
        	$directory					= "../RestApi/application/upload_ruangan/";
        	$new_name					= $_FILES["userfile"]['name'].".png";
        	// $change						= "application/upload_ruangan".'kd_ruangan'($new_name, PATHINFO_EXTENSION);
        	// $photoName 					= .".png";
        	// $save_path					= "application/upload_user/".$new_name;
        	// $config['uploadfile']		= $save_path;
            $config['upload_path']      = $directory;
            $config['allowed_types']	= 'gif|jpg|png|jpeg';
            $config['max_size']         = '1000000000';
            $config['max_width']        = '1680';
            $config['max_height']       = '1024';
            // $config['file_name'] 		= $new_name;

            $this->load->library('upload', $config) ;
            
            if(! $this->upload->do_upload('userfile'))
            {
                // $error = array('error' => $this->upload->display_errors());
                // $this->load->view('admin/ruangan/update', $error);
               // print_r($error);
            	$this->Ruangan_model->updatetRuangan();
                $this->load->view('admin/ruangan/update_sukses');	
            }
            else
            {
                $this->Ruangan_model->updateRuangan();
                $this->load->view('admin/ruangan/update_sukses');
            }
        }    
	}

	public function delete_ruangan($kd_ruangan)
	{
		$this->Ruangan_model->delete($kd_ruangan);
		$this->load->view('admin/ruangan/delete_sukses');
	}

	public function insert_gedung()
	{
	
        $this->form_validation->set_rules('kd_gedung', 'kd_gedung', 'trim|required|min_length[2]|max_length[10]');
        $this->form_validation->set_rules('nm_gedung', 'nm_gedung', 'trim|required|max_length[50]');
        $this->form_validation->set_rules('latitude', 'latitude', 'trim|required');
        $this->form_validation->set_rules('longitude', 'longitude', 'trim|required');
        
        // load model
        $this->load->model('Gedung_model');

        if($this->form_validation->run()==FALSE)
        {
            $this->load->view('admin/gedung/add');
        }
        else
        {
        	// $kd_ruangan					= 'kd_ruangan';
        	$directory					= "../RestApi/application/upload_gedung/";
        	$new_name					= $_FILES["userfile"]['name'].".png";
        	// $change						= "application/upload_ruangan".'kd_ruangan'($new_name, PATHINFO_EXTENSION);
        	// $photoName 					= .".png";
        	// $save_path					= "application/upload_gedung/".$new_name;
        	// $config['uploadfile']		= $save_path;
            $config['upload_path']      = $directory;
            $config['allowed_types']	= 'gif|jpg|png|jpeg';
            $config['max_size']         = '1000000000';
            $config['max_width']        = '1680';
            $config['max_height']       = '1024';
            // $config['file_name'] 		= $new_name;

            $this->load->library('upload', $config) ;
            
            if(! $this->upload->do_upload('userfile'))
            {
                $error = array('error' => $this->upload->display_errors());
                $this->load->view('admin/gedung/add', $error);
               // print_r($error);
            }
            else
            {
                $this->Gedung_model->insertGedung();
                $this->load->view('admin/gedung/add_sukses');
            }
        }    
	}

	public function update_gedung($kd_gedung)
	{
	
        $this->form_validation->set_rules('kd_gedung', 'kd_gedung', 'trim|required|min_length[2]|max_length[10]');
        $this->form_validation->set_rules('nm_gedung', 'nm_gedung', 'trim|required|max_length[50]');
        $this->form_validation->set_rules('latitude', 'latitude', 'trim|required');
        $this->form_validation->set_rules('longitude', 'longitude', 'trim|required');
        
        // load model
        $this->load->model('Gedung_model');
        $data['gedung_up'] = $this->Gedung_model->getGedung($kd_gedung);

        if($this->form_validation->run()==FALSE)
        {
            $this->load->view('admin/gedung/update', $data);
        }
        else
        {
        	// $kd_ruangan					= 'kd_ruangan';
        	$directory					= "../RestApi/application/upload_gedung/";
        	$new_name					= $_FILES["userfile"]['name'].".png";
        	// $change						= "application/upload_ruangan".'kd_ruangan'($new_name, PATHINFO_EXTENSION);
        	// $photoName 					= .".png";
        	// $save_path					= "application/upload_gedung/".$new_name;
        	// $config['uploadfile']		= $save_path;
            $config['upload_path']      = $directory;
            $config['allowed_types']	= 'gif|jpg|png|jpeg';
            $config['max_size']         = '1000000000';
            $config['max_width']        = '1680';
            $config['max_height']       = '1024';
            // $config['file_name'] 		= $new_name;

            $this->load->library('upload', $config) ;
            
            if(! $this->upload->do_upload('userfile'))
            {
                // $error = array('error' => $this->upload->display_errors());
                $this->Gedung_model->updateGedung();
                $this->load->view('admin/gedung/update_sukses');
               // print_r($error);
            }
            else
            {
                $this->Gedung_model->updateGedung();
                $this->load->view('admin/gedung/update_sukses');
            }
        }    
	}

	public function delete_gedung($kd_gedung)
	{
		$this->Gedung_model->delete($kd_gedung);
		$this->load->view('admin/gedung/delete_sukses');
	}

    public function insert_user()
    {
    
        $this->form_validation->set_rules('username', 'username', 'trim|required|min_length[2]|max_length[10]');
        $this->form_validation->set_rules('password', 'password', 'trim|required|max_length[50]');
        $this->form_validation->set_rules('nama_user', 'nama_user', 'trim|required');
        
        // load model
        $this->load->model('User_model');

        if($this->form_validation->run()==FALSE)
        {
            $this->load->view('admin/user/add');
        }
        else
        {
            // $kd_ruangan                  = 'kd_ruangan';
            $directory                  = "../RestApi/application/upload_user/";
            $new_name                   = $_FILES["userfile"]['name'].".png";
            // $change                      = "application/upload_ruangan".'kd_ruangan'($new_name, PATHINFO_EXTENSION);
            // $photoName                   = .".png";
            // $save_path                   = "application/upload_gedung/".$new_name;
            // $config['uploadfile']        = $save_path;
            $config['upload_path']      = $directory;
            $config['allowed_types']    = 'gif|jpg|png|jpeg';
            $config['max_size']         = '1000000000';
            $config['max_width']        = '1680';
            $config['max_height']       = '1024';
            // $config['file_name']         = $new_name;

            $this->load->library('upload', $config) ;
            
            if(! $this->upload->do_upload('userfile'))
            {
                $error = array('error' => $this->upload->display_errors());
                $this->load->view('admin/user/add', $error);
               // print_r($error);
            }
            else
            {
                $this->User_model->insertUser();
                $this->load->view('admin/user/add_sukses');
            }
        }    
    }

    public function delete_user($id_user)
    {
        $this->User_model->delete($id_user);
        $this->load->view('admin/user/delete_sukses');
    }

	public function datatable_ruangan()
	{
		$this->load->view('admin/ruangan/home');
	}

	public function data_server()
	{
		$this->load->library('Datatables');
		$this->datatables->select('r.kd_ruangan, r.nm_ruangan, r.kd_gedung, g.nm_gedung, r.photo_ruangan')
		->from('ruangan as r')->join('gedung as g' , 'r.kd_gedung = g.kd_gedung');
		// $this->datatables->select('kd_ruangan, nm_ruangan, kd_gedung')->from('ruangan');
		echo $this->datatables->generate();
	}

	public function datatable_gedung(){
		$this->load->view('admin/gedung/home');
	}

	public function data_server_gedung(){
		$this->load->library('Datatables');
		$this->datatables->select('kd_gedung, nm_gedung, photo_gedung')->from('gedung');
		echo $this->datatables->generate();
	}

    public function datatable_user()
    {
        $this->load->view('admin/user/home');
    }

    public function data_server_user()
    {
        $this->load->library('Datatables');
        $this->datatables->select('id_user, username, nama_user, photo_user')->from('user')->where('level = "member"');
        echo $this->datatables->generate();
    }

}

/* End of file Home.php */
/* Location: ./application/controllers/Home.php */
?>