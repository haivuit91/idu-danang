function previewImage(){
    var fileReader = new FileReader();
    fileReader.readAsDataURL(document.frm.file.files[0]);
    fileReader.onload = function (oFREvent) {
        document.getElementById("file").src = oFREvent.target.result;
    };
}