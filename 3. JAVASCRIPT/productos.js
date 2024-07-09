const modal = document.getElementById("modal");

window.addEventListener("click", (e) => {
  if (e.target.matches(".btn-warning")) {
    modal.classList.toggle("translate");
  }

  if (e.target.matches(".btn-danger")) {
    modal.classList.toggle("translate");
  }
});
