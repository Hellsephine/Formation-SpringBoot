init();

function init()
{
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const heroId = urlParams.get('hero')
	
	fetch("/api/hero/" + heroId)
		.then((reponse) => reponse.json())
		.then(initHero)
		.then(loadItems);
}

function initHero(hero)
{
	const heroNameElement = document.getElementById('hero-name');
	const goldElement = document.getElementById('gold');
	
	heroNameElement.textContent = hero.name;
	goldElement.textContent = hero.gold;
}

function loadItems()
{
	
}

function initItems(items)
{
	
}

