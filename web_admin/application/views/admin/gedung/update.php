<?php $this->load->view('admin/templates/header'); ?>
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <?php echo form_open_multipart('home/insert_ruangan');?>
    <legend>Update Data Gedung</legend>
    <?php echo validation_errors(); ?>
     <?php echo form_open_multipart('Home/update_gedung/'.$this->uri->segment(3)); ?>
    <?php  if(isset($error)){echo $error;} ?>

    <div class="form-group">
        <label for="">Kode Gedung</label>
        <input type="text" name="kd_gedung" class="form-control" id="kd_gedung" value="<?php echo $gedung_up[0]->kd_gedung?>">
        <label for="">Nama Gedung</label>
        <input type="text" name="nm_gedung" class="form-control" id="nm_gedung" value="<?php echo $gedung_up[0]->nm_gedung?>">
        <label for="">Latitude</label>
        <input type="text" name="latitude" class="form-control" id="latitude" value="<?php echo $gedung_up[0]->latitude?>">
        <label for="">Longitude</label>
        <input type="text" name="longitude" class="form-control" id="longitude" value="<?php echo $gedung_up[0]->longitude?>">
        <label for="">Photo</label>
        <input type="file" name="userfile" class="form-control" id="userfile">

    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <?php echo form_close(); ?>
</div>
<?php $this->load->view('admin/templates/footer_gedung'); ?>