<?php
defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;

class Gedung extends REST_Controller {
	
	function __construct($config = 'rest') {
	parent::__construct($config);
	$this->load->database();
	}

	public function index_get()
	{
		$kd_gedung = $this->get('kd_gedung');
		if ($kd_gedung == '') {
			$gedung = $this->db->get('gedung')->result();
		}else {
			$this->db->where('kd_gedung', $kd_gedung);
			$gedung = $this->db->get('gedung')->result();
		}
		$this->response($gedung, 200);
	}
}
/* End of file Ruangan.php */
/* Location: ./application/controllers/Ruangan.php */
?>
