<?php
defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Ruangan extends REST_Controller {
	
	function __construct($config = 'rest') {
	parent::__construct($config);
	$this->load->database();
	$this->load->helper('url');
	$this->load->model('User_model');
	}

	public function ruangan_get()
	{
		$get_ruangan = $this->db->query("SELECT r.kd_ruangan, r.nm_ruangan, r.kd_gedung, g.nm_gedung, r.latitude, r.longitude,r.photo_ruangan FROM ruangan as r JOIN gedung as g on r.kd_gedung = g.kd_gedung")->result();
		$this->response(array("status"=>"success","result" => $get_ruangan));
	}

	public function gedung_get()
	{
		$get_gedung = $this->db->query("SELECT g.kd_gedung, g.nm_gedung, g.photo_gedung, g.latitude, g.longitude FROM gedung as g")->result();
		$this->response(array("status"=>"success","result" => $get_gedung));
	}

	public function detailgedung_get()
	{
		$kd_gedung = $this->get('kd_gedung');
		$get_gedung = $this->db->query("SELECT g.kd_gedung, g.nm_gedung, g.photo_gedung, g.latitude, g.longitude FROM gedung as g 
			where g.kd_gedung='".$kd_gedung."'")->result();
		$this->response(array("status"=>"success","result" => $get_gedung));

		// $this->db->select('*');
		// $this->db->from('gedung');
		// $this->db->where('kd_gedung', $kd_gedung);
		// $query = $this->db->get();
		// $row = $query->first_row();

		// if ($query->num_rows()==1) {
		// 	return $this->response(array('status' => 'success', 'result' => $row));
  //       }
  //       else{
  //           return $this->response(array('status'=> 'failed',502));
  //       }
	}

	public function index_get()
	{
		$id_user = $this->get('id_user');
		if ($id_user == '') {
            $data_user1 = $this->db->get('user')->result();
        } else {
            $this->db->where('id_user', $id_user);
            $data_user2 = $this->db->get('user')->result();
        }
        if (!$data_user1) {
	        $this->response($data_user2, 200);	
        } else{
        	$this->response("Failed");
        }
    }

    function user_post() {
		$action = $this->post('action');
		$data_user = array('id_user' => $this->post('id_user'),
							  'username' => $this->post('username'),
							  'password' => md5($this->post('password')),
							  'nama_user' => $this->post('nama_user'),
							  'telpon' => $this->post('telpon'),
							  'photo_user' => $this->post('photo_user'));
		if ($action==='put'){
			$this->updateUser($data_user);
		}else{
			$this->response(array("status"=>"failed","message" => "action harus diisi"));
		}
	}

	public function login_post()
	{
        $this->db->select('*');
        $this->db->from('user');
        $this->db->where('username', $this->input->post('username'));
        $query = $this->db->get();
        $row = $query->first_row();


        if($query->num_rows()==1){
            return $this->response(array('status' => 'success', 'result' => $row));
        }
        else{
            return $this->response(array('status'=> 'failed',502));
        }
    }


    // public function login_post() {
    //     // Get the post data
    //     $username = $this->post('username');
    //     $password = $this->post('password');
        
    //     // Validate the post data
    //     if(!empty($username) && !empty($password)){
            
    //         // Check if any user exists with the given credentials
    //         $con['returnType'] = 'single';
    //         $con['conditions'] = array(
    //             'username' => $username,
    //             'password' => md5($password),
    //             // 'status' => 1
    //         );
    //         $user = $this->User_model->getRows($con);
            
    //         if($user){
    //             // Set the response and exit
    //             $this->response([
    //                 'status' => TRUE,
    //                 'message' => 'User login successful.',
    //                 'data' => $user
    //             ], REST_Controller::HTTP_OK);
    //         }else{
    //             // Set the response and exit
    //             //BAD_REQUEST (400) being the HTTP response code
    //             $this->response("Wrong username or password.", REST_Controller::HTTP_BAD_REQUEST);
    //         }
    //     }else{
    //         // Set the response and exit
    //         $this->response("Provide username and password.", REST_Controller::HTTP_BAD_REQUEST);
    //     }
    // }


    function updateUser($data_user){
		$uploaddir = str_replace("application/", "", APPPATH).'upload_user/';
		if(!file_exists($uploaddir) && !is_dir($uploaddir)) {
			echo mkdir($uploaddir, 0777, true);
		}
		if(!empty($_FILES)){
			$path = $_FILES['photo_user']['name'];
			$user_img = $data_user['id_user'].'.' ."png";
			$uploadfile = $uploaddir . $user_img;
			$data_user['photo_user'] = $user_img;
		}
		if (empty($data_user['id_user'])){
			$this->response(array('status' => "failed", "message"=>"Id User harus diisi"));
		}else if (empty($data_user['username'])){
			$this->response(array('status' => "failed", "message"=>"Username harus diisi"));
		}else if (empty($data_user['password'])){
			$this->response(array('status' => "failed", "message"=>"Password harus diisi"));
		}else if (empty($data_user['nama_user'])){
			$this->response(array('status' => "failed", "message"=>"Nama User harus diisi"));
		}else if (empty($data_user['telpon'])){
			$this->response(array('status' => "failed", "message"=>"Telpon harus diisi"));
		}else if (empty($data_user['level'])){
			$this->response(array('status' => "failed", "message"=>"Level harus diisi"));
		}else{
			$get_user_baseid = $this->db->query("SELECT * FROM user as u WHERE u.id_user='".$data_user['id_user']."'")->result();
			if(empty($get_user_baseid)){
				$this->response(array('status' => "failed", "message"=>"Id User Tidak ada dalam database"));
			}else{
				if (!empty($_FILES["photo_user"]["name"])) {
					if (move_uploaded_file($_FILES["photo_user"]["tmp_name"],$uploadfile)){
						$insert_image = "success";
					} else{
						$insert_image = "failed";
					}
				}else{
						$insert_image = "Image Tidak ada Masukan";
				}
					if ($insert_image==="success"){
						$update= $this->db->query("Update user Set username ='".$data_user['username']."', password ='".$data_user['password']."', nama_user ='".$data_user['nama_user']."', telpon ='".$data_user['telpon']."', photo_user ='".$data_user['photo_user']."' Where id_user ='".$data_user['id_user']."'");
						$data_user['photo_user'] = base_url()."upload_user/".$user_img;
					}else{
						$update= $this->db->query("Update user Set username ='".$data_user['username']."', password ='".$data_user['password']."', nama_user ='".$data_user['nama_user']."' , telpon ='".$data_user['telpon']."' Where id_user ='".$data_user['id_user']."'");
						$getPhotoPath =$this->db->query("SELECT photo_user FROM user Where id_user='".$data_user['id_user']."'")->result();
						if(!empty($getPhotoPath)){
							foreach ($getPhotoPath as $row){
								$user_img = $row->photo_user;
								$data_user['photo_user'] = base_url()."upload_user/".$user_img;
							}
						}
					}
				if ($update){
					$this->response(array('status'=>'success','result' => array($data_user),"message"=>$update));
				}
			}
		}
	}
 
        
		// if (empty($data_user['Username'])){
		// 	$this->response(array('status' => "failed", "message"=>"Username Tidak Ada"));
		// }else{
		// $get_user = $this->db->query("SELECT u.username, u.password, u.telpon, u.photo_user FROM user as u WHERE u.id_user = '".$data_user['Username']."'")->result();
		// $this->respone(array("status"=>"success","result" => $get_user));
		// }
	
}
/* End of file Ruangan.php */
/* Location: ./application/controllers/Ruangan.php */
?>