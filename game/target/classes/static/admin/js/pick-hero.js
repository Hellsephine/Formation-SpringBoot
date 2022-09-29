getHeroes();

function getHeroes()
{
	fetch("/api/heroes")
		.then((reponse) => reponse.json())
		.then(createHeroList)
}

function createHeroList(heroList)
{
	const heroDiv = document.getElementById('hero-list');
	
	for (let hero of heroList)
	{
		const heroTag = createHero(hero);
		heroDiv.appendChild(heroTag);
	}
}

function createHero(hero)
{
	const div = document.createElement('div');
	
	const nameTag = document.createElement('h2');
	nameTag.textContent = hero.name;
	
	div.appendChild(nameTag);
	
	const goldTag = document.createElement('p');
	goldTag.textContent = 'Or de départ : ' + hero.gold;
	div.appendChild(goldTag);
	
	const buttonTag = document.createElement('button');
	buttonTag.textContent = 'Choisir';
	buttonTag.setAttribute('data-id', hero.id);
	buttonTag.addEventListener('click', onPickHero);
	div.appendChild(buttonTag);
	
	return div;
}

function onPickHero()
{
	const pickedHero = this.getAttribute('data-id');
	window.location.replace("/game/pick-items?hero=" + pickedHero);
}