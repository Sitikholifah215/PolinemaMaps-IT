<?php $this->load->view('admin/templates/header'); ?>
 <div class="alert alert-success" >
    <strong>Data Berhasil ditambah</strong>
    <?php
    echo anchor('Home/datatable_user','Kembali ke Halaman Depan');
    ?>
    </div>
<?php $this->load->view('admin/templates/footer_user'); ?>