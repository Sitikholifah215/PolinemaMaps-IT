<?php $this->load->view('admin/templates/header'); ?>
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <?php echo form_open_multipart('home/insert_user');?>
    <legend>Tambah Data User</legend>
    <?php echo validation_errors(); ?>
    <?php  if(isset($error)){echo $error;} ?>

    <div class="form-group">
        <label for="">Username</label>
        <input type="text" name="username" class="form-control" id="username" placeholder="Username">
        <label for="">Password</label>
        <input type="password" name="username" class="form-control" id="password" placeholder="Password">
        <label for="">Nama User</label>
        <input type="text" name="nama_user" class="form-control" id="nama_user" placeholder="Nama User">
        <label for="">Photo</label>
        <input type="file" name="userfile" class="form-control" id="userfile">

    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <?php echo form_close(); ?>
</div>
<?php $this->load->view('admin/templates/footer_user'); ?>