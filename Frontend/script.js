const loginButton = document.getElementById("loginButton");
const signupButton = document.getElementById("signupButton");
const loginDialog = document.getElementById("loginBox");
const signupDialog = document.getElementById("signupBox");
const bgAnimations = document.getElementById('bgAnimation');
const numberofColorBoxes=400;
for(let i=0;i<numberofColorBoxes; i++)
{
	const colorBox=document.createElement('div');
	colorBox.classList.add('colorBox');
	bgAnimation.append(colorBox)
}
loginButton.addEventListener("click", () => {
    loginDialog.style.display = "block";
    signupDialog.style.display = "none";
});

signupButton.addEventListener("click", () => {
    loginDialog.style.display = "none";
    signupDialog.style.display = "block";
});

const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", (event) => {
    event.preventDefault();
    // Process login form data and submit if needed
    alert("Login form submitted!");
});

const signupForm = document.getElementById("signupForm");
signupForm.addEventListener("submit", (event) => {
    event.preventDefault();
    // Process signup form data and submit if needed
    alert("Signup form submitted!");
});


