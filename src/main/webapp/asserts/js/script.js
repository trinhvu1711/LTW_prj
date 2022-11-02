// SIDEBAR DROPDOWN
const allDropdown = document.querySelectorAll("#sidebar .side-dropdown");

allDropdown.forEach((item) => {
  const a = item.parentElement.querySelector("a:first-child");

  a.addEventListener("click", function (e) {
    e.preventDefault();
    this.classList.toggle("active");
    item.classList.toggle("show");
    item.classList.toggle("active");
  });
});

//PROFILE DROPDOWN
const profile = document.querySelector("nav .profile");
const imgProfile = profile.querySelector("img");
const dropdownProfile = profile.querySelector(".profile-link");

imgProfile.addEventListener("click", function () {
  dropdownProfile.classList.toggle("show");
});

window.addEventListener("click", function (e) {
  if (e.target !== imgProfile) {
    if (e.target != dropdownProfile) {
      if (dropdownProfile.classList.contains("show")) {
        dropdownProfile.classList.remove("show");
      }
    }
  }
});

//SIDEBAR COLLAPSE
const toggleSidebar =  document.querySelector('nav .toggle-sidebar');
const sidebar = document.getElementById('sidebar');
toggleSidebar.addEventListener('click', function(){
  sidebar.classList.toggle('hide');
})