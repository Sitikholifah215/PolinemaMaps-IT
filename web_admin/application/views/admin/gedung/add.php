<?php $this->load->view('admin/templates/header'); ?>
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <?php echo form_open_multipart('home/insert_gedung');?>
    <legend>Tambah Data Gedung</legend>
    <?php echo validation_errors(); ?>
    <?php  if(isset($error)){echo $error;} ?>

    <div class="form-group">
        <label for="">Kode Gedung</label>
        <input type="text" name="kd_gedung" class="form-control" id="kd_gedung" placeholder="Kode Gedung">
        <label for="">Nama Gedung</label>
        <input type="text" name="nm_gedung" class="form-control" id="nm_gedung" placeholder="Nama Gedung">
        <label for="">Latitude</label>
        <input type="text" name="latitude" class="form-control" id="latitude" placeholder="Latitude">
        <label for="">Longitude</label>
        <input type="text" name="longitude" class="form-control" id="longitude" placeholder="Longitude">
        <label for="">Photo</label>
        <input type="file" name="userfile" class="form-control" id="userfile">

    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <?php echo form_close(); ?>
</div>
<?php $this->load->view('admin/templates/footer_gedung'); ?>