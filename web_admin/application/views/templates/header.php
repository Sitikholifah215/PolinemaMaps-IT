<!DOCTYPE html>
<html lang="en">
<head>
  <title>Web Admin SILORU</title>
  <meta http-equiv="X-UA-Compatible" content="Firefox">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="<?= base_url('assets/css/style.css')?>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->
  <script defer src="https://use.fontawesome.com/releases/v5.0.2/js/all.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

</head>
<body>
  
<div>
<nav class="navbar navbar-expand-lg sticky-top navbar-dark" style="background-color: #0d5fe2; margin-bottom:30px;">
    <a class="navbar-brand" href="<?= site_url('Main')?>"><i class="fas fa-university"></i> SILORU </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<?= site_url('Main') ?>">
                   <i class="fas fa-home"></i> Home <span class="sr-only">(current)</span>
                </a>
            </li>
          </ul>
          <ul class="nav navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<?= site_url('Main/Login')?>">
                   <i class="fas fa-user"></i> Login <span class="sr-only">(current)</span>
                </a>
            </li>
        </ul>
    </div>
  </nav>
</div>