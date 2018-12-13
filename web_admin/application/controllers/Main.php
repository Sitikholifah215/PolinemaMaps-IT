<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Main extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		//Do your magic here
		$this->load->database();
		$this->load->helper('url', 'form');
		$this->load->library('form_validation');
	}

	public function index()
	{
		$this->load->view('main');
	}

	public function login()
	{
		$this->load->view('login_page');
	}

	public function cekLogin()
	{
		$this->form_validation->set_rules('username', 'username', 'trim|required');
		$this->form_validation->set_rules('password', 'password', 'trim|required|callback_cekDb');
		$this->load->model('User_model');
		$username = $this->input->post('username');
		$password = $this->input->post('password');
		$where = array(
			'username' => $username,
			'password' => md5($password)
			);
		$cek = $this->User_model->ceklogin("user",$where)->num_rows();
		if($cek > 0){
 
			$data_session = array(
				'username' => $username,
				'status' => "login"
				);
 
			$this->session->set_userdata($data_session);
 			redirect('Home','refresh');
			// redirect(base_url("admin"));
 
		}else{
			echo "Username dan password salah !";
		}
	}

	function logout(){
		$this->session->sess_destroy();
		redirect('Main','refresh');
	}

	// public function cekDB($password)
	// {
	// 	$this->load->model('User_model');
	// 	$username = $this->input->post('username');
	// 	$result = $this->User_model->login($username, $password);

	// 	if ($result) {
	// 		$sess_array = array();
	// 		foreach ($result as $row)
	// 		{
	// 			$sess_array = array(
	// 			'id_user'=>$row->id_user,
	// 			'username'=>$row->username
	// 			);
	// 			$this->session->set_userdata('logged_in',$sess_array);
	// 		}
	// 		return true;
	// 	}
	// 	else
	// 	{
	// 		$this->form_validation->set_message('cekDb',"Login Gagal Username dan Password tidak valid");
	// 		return false;
	// 	}
	// }

}

/* End of file Main.php */
/* Location: ./application/controllers/Main.php */