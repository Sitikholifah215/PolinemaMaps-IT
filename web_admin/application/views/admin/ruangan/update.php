<?php $this->load->view('admin/templates/header'); ?>
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <?php echo form_open_multipart('home/insert_ruangan');?>
    <legend>Edit Data Ruangan</legend>
    <!-- <?php
    var_dump($ruangan_up); ?> -->
    <?php echo validation_errors(); ?>
    <?php echo form_open_multipart('Home/update_ruangan/'.$this->uri->segment(3)); ?>
    <?php  if(isset($error)){echo $error;} ?>

    <div class="form-group">
        <label for="">Kode Ruangan</label>
        <input type="text" name="kd_ruangan" class="form-control" id="kd_ruangan" value="<?php echo $ruangan_up[0]->kd_ruangan?>">
        <label for="">Nama Ruangan</label>
        <input type="text" name="nm_ruangan" class="form-control" id="nm_ruangan" value="<?php echo $ruangan_up[0]->nm_ruangan?>">
        <label for="">Kode Gedung</label>
        <select class="form-control" id="kd_gedung" name="kd_gedung" value="<?php echo $ruangan_up[0]->kd_gedung?>">
        	<?php 

            foreach($dropdown as $row)
            { 
              echo '<option value="'.$row->kd_gedung.'">'.$row->kd_gedung.'</option>';
            }
            ?>
        </select>
        <label for="">Latitude</label>
        <input type="text" name="latitude" class="form-control" id="latitude" value="<?php echo $ruangan_up[0]->latitude?>">
        <label for="">Longitude</label>
        <input type="text" name="longitude" class="form-control" id="longitude" value="<?php echo $ruangan_up[0]->longitude?>">
        <label for="">Photo</label>
        <input type="file" name="userfile" class="form-control" id="userfile">

    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <?php echo form_close(); ?>
</div>
<?php $this->load->view('admin/templates/footer'); ?>