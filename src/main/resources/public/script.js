function revealOriginal() {
    document.getElementById("original-text").classList.remove('hidden');
}

var revealForm = document.querySelector("form");
revealForm.addEventListener("submit", function(event) {
    event.preventDefault();
    revealOriginal();
});
