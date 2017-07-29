$(document).on("scroll", function() {
  if ($(document).scrollTop() > 120) {
    $("nav").addClass("small");
  } else {
    $("nav").removeClass("small");
  }
});
document.querySelector('button').addEventListener('click', function() {
	  if(document.querySelector('.demo')!=null)
	  document.querySelector('.demo').innerHTML = '<h1>Injected content.</h1>';
	})