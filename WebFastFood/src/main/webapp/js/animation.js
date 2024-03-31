function zoomIn(element) {
	element.querySelector("img").style.transform = "scale(1.2)";
}

function zoomOut(element) {
	element.querySelector("img").style.transform = "scale(1)";
}

function navigateToPage(pageURL) {
	window.location.href = pageURL; // Chuyển trang
}