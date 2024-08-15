const navMobile = document.querySelector('.nav-mobile');
const navBtn = document.querySelector('.hamburger');
const navLinks = document.querySelectorAll('.nav__link');
const itGeeksLogo = document.querySelector('.logo')
const footerYear = document.querySelector('.footer__year');

document.addEventListener('DOMContentLoaded', () => {
    navBtn.addEventListener('click', () => {
        navBtn.classList.toggle('is-active');
        navMobile.classList.toggle('nav-mobile--active');
    });
});

navLinks.forEach(item => {
	item.addEventListener('click', () => {
		navMobile.classList.remove('nav-mobile--active')
		navBtn.classList.remove('is-active')
	})
})

itGeeksLogo.addEventListener('click', () => {
	navBtn.classList.remove('is-active')
	navMobile.classList.remove('nav-mobile--active')
})

document.addEventListener('DOMContentLoaded', function() {
    const nav = document.querySelector('.mobile-underline'); // Wybierz element nawigacji
    const scrollDistance = 200; // Dystans przewinięcia, po którym dodajemy cień

    function handleScroll() {
        if (window.scrollY > scrollDistance) {
            nav.classList.add('nav-scrolled');
        } else {
            nav.classList.remove('nav-scrolled');
        }
    }

    window.addEventListener('scroll', handleScroll);

    // Wywołanie funkcji na starcie, aby ustawić poprawny stan w przypadku przewinięcia podczas ładowania
    handleScroll();
});
