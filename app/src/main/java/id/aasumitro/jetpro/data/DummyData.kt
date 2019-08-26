package id.aasumitro.jetpro.data

import id.aasumitro.jetpro.data.model.Entity

/**
 * Created by A. A. Sumitro on 22/08/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

object DummyData {

    fun generateMovies(): ArrayList<Entity> {
        val movies = ArrayList<Entity>()
        movies.add(Entity(
            poster = "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
            year = 2019,
            title = "Fast & Furious Presents: Hobbs & Shaw",
            overview = "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",
            rating = "7.0/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/a4BfxRK8dBgbQqbRxPs8kmLd8LG.jpg",
            title ="The Old Man & the Gun",
            year = 2018,
            overview = "The true story of Forrest Tucker, from his audacious escape from San Quentin at the age of 70 to an unprecedented string of heists that confounded authorities and enchanted the public. Wrapped up in the pursuit are a detective, who becomes captivated with Forrest’s commitment to his craft, and a woman, who loves him in spite of his chosen profession.",
            rating = "6.7/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/3iYQTLGoy7QnjcUYRJy4YrAgGvp.jpg",
            title = "Aladdin",
            year = 2019,
            overview = "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
            rating = "7.3/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/or06FN3Dka5tukK1e9sl16pB3iy.jpg",
            title = "Avengers: Endgame",
            year = 2019,
            overview = "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
            rating = "8.6/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg",
            title = "Spider-Man: Far from Home",
            year = 2019,
            overview = "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
            rating = "7.9/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg",
            title = "Once Upon a Time in Hollywood",
            year = 2019,
            overview = " A faded television actor and his stunt double strive to achieve fame and success in the film industry during the final years of Hollywood's Golden Age in 1969 Los Angeles.",
            rating = "8.4/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            title = "Alita: Battle Angel",
            year = 2019,
            overview = "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            rating = "7.4/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/wgQ7APnFpf1TuviKHXeEe3KnsTV.jpg",
            title = "Pokémon Detective Pikachu",
            year = 2019,
            overview = "In a world where people collect pocket-size monsters (Pokémon) to do battle, a boy comes across an intelligent monster who seeks to be a detective.",
            rating = "6.7/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg",
            title = "John Wick: Chapter 3 – Parabellum",
            year = 2019,
            overview = "Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.",
            rating = "7.9/10 (imdb)"
        ))
        movies.add(Entity(
            poster = "/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg",
            title = "Captain Marvel",
            year = 2019,
            overview = "The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.",
            rating = "7.0/10 (imdb)"
        ))
        return movies

    }

    fun generateShows(): ArrayList<Entity> {
        val shows = ArrayList<Entity>()
        shows.add(Entity(
            poster = "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
            year = 2012,
            title = "Arrow",
            overview = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            rating = "7.6/10 (imdb)"
        ))
        shows.add(Entity(
            poster = "/fki3kBlwJzFp8QohL43g9ReV455.jpg",
            year = 2014,
            title = "The Flash",
            overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            rating = "7.8/10 (imdb)"
        ))
        shows.add(Entity(
            poster = "/cXiETfFK1BTLest5fhTLfDLRdL6.jpg",
            year = 2013,
            title = "Marvel's Agents of S.H.I.E.L.D.",
            overview = "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.",
            rating = "7.5/10 (imdb)"
        ))
        shows.add(Entity(
            poster = "/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg",
            year = 2016,
            title = "Stranger Things",
            overview = "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl.",
            rating = "8.9/10 (imdb)"
        ))
        shows.add(Entity(
            poster = "/iE3s0lG5QVdEHOEZnoAxjmMtvne.jpg",
            year = 2015,
            title = "One-Punch Man",
            overview = "Saitama is a hero who only became a hero for fun. After three years of “special” training, though, he’s become so strong that he’s practically invincible. In fact, he’s too strong—even his mightiest opponents are taken out with a single punch, and it turns out that being devastatingly powerful is actually kind of a bore. With his passion for being a hero lost along with his hair, yet still faced with new enemies every day, how much longer can he keep it going?",
            rating ="8.9/10 (imdb)"
        ))
        shows.add(Entity(
            poster = "/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
            year = 2014,
            title = "Gotham",
            overview = "Before there was Batman, there was GOTHAM.\n\nEveryone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            rating = "7.8/10 (imdb)"
        ))
        shows.add(Entity(
            poster =  "/gJI77i79KnRuc9mGPKADPZWAE8O.jpg",
            year = 1999,
            title = "One Piece",
            overview = "Years ago, the fearsome pirate king Gol D. Roger was executed, leaving a huge pile of treasure and the famous \"One Piece\" behind. Whoever claims the \"One Piece\" will be named the new pirate king. Monkey D. Luffy, a boy who consumed one of the \"Devil's Fruits\", has it in his head that he'll follow in the footsteps of his idol, the pirate Shanks, and find the One Piece. It helps, of course, that his body has the properties of rubber and he's surrounded by a bevy of skilled fighters and thieves to help him along the way. Monkey D. Luffy brings a bunch of his crew followed by, Roronoa Zoro, Nami, Usopp, Sanji, Tony-Tony Chopper, Nico Robin, Franky, and Brook. They will do anything to get the One Piece and become King of the Pirates!",
            rating ="9.2/10 (imdb)"
        ))
        shows.add(Entity(
            poster = "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
            year = 2011,
            title = "Game of Thrones",
            overview = "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            rating = "9.4/10 (imdb)"
        ))
        shows.add(Entity(
            poster = "/1sBx2Ew4WFsa1YY32vlHt079O03.jpg",
            year = 2016,
            title = "Lucifer",
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            rating = "8.2/10 (imdb)"
        ))
        shows.add(Entity(
            poster = "/ydSvHgksuB8Ix0V05QEZBKrnIcg.jpg",
            year = 1999,
            title = "Law & Order: Special Victims Unit",
            overview = "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
            rating = "8.0/10 (imdb)"
        ))
        return shows
    }

}