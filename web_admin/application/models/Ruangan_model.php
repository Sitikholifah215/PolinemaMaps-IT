<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Ruangan_model extends CI_Model {

	public function __construct()
	{
		parent::__construct();
		//Do your magic here
		$this->load->database();
	}

	public function getRuanganUp($kd_ruangan)
	{
		$this->db->where('kd_ruangan', $kd_ruangan);
		$query = $this->db->get('ruangan');
		return $query->result();
	}

	public function insertRuangan()
	{
		$object = array(
            'kd_ruangan' => $this->input->post('kd_ruangan'),
            'nm_ruangan' => $this->input->post('nm_ruangan'),
            'kd_gedung' => $this->input->post('kd_gedung'),
            'latitude' => $this->input->post('latitude'),
            'longitude' => $this->input->post('longitude'),
            'photo_ruangan'=> $this->upload->data('file_name'),
    );
           $this->db->insert('ruangan',$object);
	}

	public function updateRuangan($kd_ruangan)
	{
		$object = array(
			'kd_ruangan' => $this->input->post('kd_ruangan'),
            'nm_ruangan' => $this->input->post('nm_ruangan'),
            'kd_gedung' => $this->input->post('kd_gedung'),
            'latitude' => $this->input->post('latitude'),
            'longitude' => $this->input->post('longitude'),
            'photo_ruangan'=> $this->upload->data('file_name'),
        );
        $this->db->where('kd_ruangan', $kd_ruangan);
        $this->db->update('ruangan', $object);
	}

	public function delete($kd_ruangan)
	{
		$getPhotoPath =$this->db->query("SELECT photo_ruangan FROM ruangan Where kd_ruangan='".$kd_ruangan."'")->result();
		if(!empty($getPhotoPath)){
			foreach ($getPhotoPath as $row)
			{
				$path = str_replace("../../RestApi/application/upload_ruangan", "", APPPATH).$row->photo_ruangan;
			}
				//delete image
			unlink($path);
		$this->db->where('kd_ruangan', $kd_ruangan);
		// unlink("../../RestApi/aplication/upload_ruangan/".$photo_ruangan);
		$this->db->delete('ruangan');
		} else{
			
		}
	}
	

}

/* End of file Ruangan_model.php */
/* Location: ./application/models/Ruangan_model.php */