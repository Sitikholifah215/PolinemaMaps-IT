<?php $this->load->view('admin/templates/header'); ?>
 <div class="alert alert-success" >
    <strong>Data Berhasil dihapus</strong>
    <?php
    echo anchor('Home/datatable_gedung','Kembali ke Halaman Depan');
    ?>
    </div>
<?php $this->load->view('admin/templates/footer_gedung'); ?>