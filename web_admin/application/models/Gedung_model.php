<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Gedung_model extends CI_Model {

public function __construct()
	{
		parent::__construct();
		//Do your magic here
		$this->load->database();
	}	

	public function getKd()
	{
		$query = $this->db->query("Select kd_gedung From gedung");
		return $query->result();
	}

	public function getGedung($kd_gedung)
	{
		$this->db->where('kd_gedung', $kd_gedung);
		$query = $this->db->get('gedung');
		return $query->result();
	}

	public function insertGedung()
	{
		$object = array(
            'kd_gedung' => $this->input->post('kd_gedung'),
            'nm_gedung' => $this->input->post('nm_gedung'),
			'latitude' => $this->input->post('latitude'),
            'longitude' => $this->input->post('longitude'),
            'photo_gedung'=> $this->upload->data('file_name'),
		);
		$this->db->insert('gedung', $object);
	}

	public function updateGedung($kd_gedung)
	{
		$object = array(
            'kd_gedung' => $this->input->post('kd_gedung'),
            'nm_gedung' => $this->input->post('nm_gedung'),
			'latitude' => $this->input->post('latitude'),
            'longitude' => $this->input->post('longitude'),
            'photo_gedung'=> $this->upload->data('file_name'),
		);
		$this->db->where('kd_gedung', $kd_gedung);
		$this->db->update('gedung', $object);
	}

	public function delete($kd_gedung)
	{
		// $getPhotoPath =$this->db->query("SELECT photo_gedung FROM gedung Where kd_gedung='".$kd_gedung."'")->result();
		// if(!empty($getPhotoPath)){
		// 	foreach ($getPhotoPath as $row)
		// 	{
		// 		$path = str_replace("../../../RestApi/application/upload_gedung", "", APPPATH).$row->photo_gedung;
		// 	}
		// 		//delete image
		// 	unlink($path);
		$this->db->where('kd_gedung', $kd_gedung);
		unlink("../../../RestApi/aplication/upload_gedung/".$kd_gedung);
		$this->db->delete('gedung');
		// } else{
			
		// }
	}

}

/* End of file Gedung_model.php */
/* Location: ./application/models/Gedung_model.php */
?>