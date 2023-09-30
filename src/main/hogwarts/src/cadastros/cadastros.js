function toggleSidebar() {
    var sidebar = document.getElementById('sidebar');
    var sidebarItems = document.querySelectorAll('.sidebar ul li');
    var ul = document.querySelector('.sidebar ul');

    sidebar.classList.toggle('open');

    if (ul.style.display === 'none') {
        ul.style.display = 'block';
    } else {
        ul.style.display = 'none';
    }
    sidebarItems.forEach(function(item) {
        item.style.display = item.style.display === 'none' ? 'block' : 'none';
    });
}