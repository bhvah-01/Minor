const friendForm = document.getElementById('friendForm');
const friendNameInput = document.getElementById('friendName');
const friendAgeInput = document.getElementById('friendAge');
const friendsList = document.getElementById('friendsList');

friendForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const friendName = friendNameInput.value;
    const friendAge = friendAgeInput.value;

    if (friendName && friendAge) {
        const listItem = document.createElement('li');
        listItem.innerHTML = `${friendName} (${friendAge} years) <button class="removeFriend">Remove</button>`;
        friendsList.appendChild(listItem);

        friendNameInput.value = '';
        friendAgeInput.value = '';

        // Add event listener to the remove button
        const removeButton = listItem.querySelector('.removeFriend');
        removeButton.addEventListener('click', () => {
            listItem.remove();
        });
    }
});
