 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
 <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<!--  <script src="<?=base_url()?>assets/datatables.js"></script> -->
 
<!-- <script type="text/javascript" src="<?php base_url()?>assets/js/jquery.js"></script>
<script type="text/javascript" src="<?php base_url()?>assets/js/bootstrap.min.js"></script>

<script src="<?php base_url()?>assets/js/datatables.min.js"></script> -->
  <script type="text/javascript">
 	$(document).ready(function() {
    $('#ruangan').DataTable({
    	"processing":true,
    	"serverSide":true,
    	"lengthMenu":[[10,3,6,-1],[10,3,6,"All"]],
    	"ajax":{
    		url : "<?php echo site_url('Home/data_server') ?>",
    		type : "POST"
    	},
    	"columnDefs":
    	[
    		{
    			"targets":0,
    			"data":"kd_ruangan"
    		},
    		{
    			"targets":1,
    			"data":"nm_ruangan"
    		},
    		{
    			"targets":2,
    			"data":"kd_gedung"
    		},
    		{
    			"targets":3,
    			"data":"nm_gedung"
    		},
    		{
    			"targets":4,
    			"data":"photo_ruangan",
    			"render":function(data,type,full,meta){
    				return '<img src="../../RestApi/application/upload_ruangan/'+data+'" width="75px" height="75px">';
    			}
    		},
    		{
    			"targets":5,
    			"data":null,
    			"searchable":false,
    			"render":function(data,type,full,meta){
    				return '<a href="<?=site_url()?>/Home/update_ruangan/'+data["kd_ruangan"]+'">Edit</a>'
    			}
    		},
    		{
    			"targets":6,
    			"data":null,
    			"searchable":false,
    			"render":function(data,type,full,meta){
    				return '<a href="<?=site_url()?>/Home/delete_ruangan/'+data["kd_ruangan"]+'">Delete</a>'
    			}
    		}
    	]

    });
	});
 </script>
