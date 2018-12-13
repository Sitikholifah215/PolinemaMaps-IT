<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class User_model extends CI_Model {

	public function __construct()
	{
		parent::__construct();
		//Do your magic here
		$this->load->database();
	}

	public function insert_user()
	{
		$object = array(
            'username' => $this->input->post('username'),
            'password' => md5($this->input->post('password')),
            'nama_user' => $this->input->post('nama_user'),
            'photo_user'=> $this->upload->data('file_name'),
    );
           $this->db->insert('user',$object);
	}

	public function ceklogin($table,$where)
	{
		return $this->db->get_where($table,$where);
	}

	public function delete($id_user)
	{
		$getPhotoPath =$this->db->query("SELECT photo_user FROM user Where id_user='".$id_user."'")->result();
		if(!empty($getPhotoPath)){
			foreach ($getPhotoPath as $row)
			{
				$path = str_replace("../../../RestApi/application/upload_user", "", APPPATH).$row->photo_user;
			}
				//delete image
			unlink($path);
		$this->db->where('id_user', $id_user);
		// unlink("../../../RestApi/aplication/upload_user/".$photo_user);
		$this->db->delete('user');
		} else{
			
		}
	}

}

/* End of file User_model.php */
/* Location: ./application/models/User_model.php */
?>