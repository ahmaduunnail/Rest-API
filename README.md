# Android Rest-API

[Aplikasi Bisa dicoba disini](https://github.com/ahmaduunnail/Rest-API/raw/master/app/release/app-release.apk)

## API
adalah singkatan dari Application Programming Interface yaitu sebuah software
yang memungkinkan para developer untuk mengintegrasikan dan mengizinkan dua aplikasi yang
berbeda secara bersamaan untuk saling terhubung satu sama lain.

## Rest API
merupakan salah satu dari desain arsitektur yang terdapat di dalam API itu
sendiri. Dan cara kerja dari RESTful API yaitu REST client akan Melakukan akses pada
data/resource pada REST server dimana masing-masing resource. Atau data/resource tersebut
akan dibedakan oleh sebuah global ID atau URIs (Universal Resource Identifiers).
Jadi, Nantinya data yang diberikan oleh REST server itu bisa berupa format text, JSON atau
XML. Dan saat ini format yang paling populer dan paling banyak digunakan adalah format
JSON.
#
<code><img height=500 src="https://github.com/ahmaduunnail/Rest-API/blob/master/.github/(1).png" alt="Linear Layout"></code>
<code><img height=500 src="https://github.com/ahmaduunnail/Rest-API/blob/master/.github/(2).png" alt="Linear Layout"></code>
#

## Retrofit
adalah sebuah library android yang membantu pengembang untuk melakukan
request ke sebuah endpoint REST API. Library ini dikembangkan oleh Square Inc
(https://github.com/square) sebuah perusahaan yang berbasis di Amerika Serikat.
#
<code><img height=500 src="https://github.com/ahmaduunnail/Rest-API/blob/master/.github/(3).png" alt="Relative Layout"></code>
<code><img height=500 src="https://github.com/ahmaduunnail/Rest-API/blob/master/.github/(4).png" alt="Relative Layout"></code>
#

## Volley
Library merupakan merupakan produk yang diperkenalkan oleh Google untuk
mempermudah pertukaran data tanpa harus membuat deretan kode yang sangat panjang. Secara
default volley menggunakan metode singkronisasi.
#
<code><img height=500 src="https://github.com/ahmaduunnail/Rest-API/blob/master/.github/(3).png" alt="Intent-1"></code>
<code><img height=500 src="https://github.com/ahmaduunnail/Rest-API/blob/master/.github/(5).png" alt="Intent-2"></code>
#

## Perbedaan Rtrofit dan Volley 
Retrofit mempermudah kita dalam melakukan requests dan mengupload JSON data
melalui REST-based website, sedangkan Volley hampir sama hanya saja memiliki
module untuk mengeload gambar sendiri sedangkan Retrofit tidak