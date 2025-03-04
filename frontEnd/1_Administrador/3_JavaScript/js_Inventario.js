document.addEventListener('DOMContentLoaded', () => {
    const menuItems = document.querySelectorAll('#menu > li');

    menuItems.forEach(item => {
        item.addEventListener('mouseover', () => {
            const dropdown = item.querySelector('.dropdown');
            if (dropdown) {
                dropdown.style.display = 'block';
            }
        });

        item.addEventListener('mouseout', () => {
            const dropdown = item.querySelector('.dropdown');
            if (dropdown) {
                dropdown.style.display = 'none';
            }
        });
    });
});

