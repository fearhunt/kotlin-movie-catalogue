package com.example.kotlinmoviecatalogue.util

import com.example.kotlinmoviecatalogue.entity.ShowsEntity

object DataDummy {
    fun generateDummy(showsType: String): List<ShowsEntity> {
        val shows = ArrayList<ShowsEntity>()

        if (showsType == "movies") {
            shows.add(
                ShowsEntity(
                    "A Star Is Born",
                    "@drawable/poster_a_star_is_born",
                    "2018",
                    "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                    75,
                    arrayListOf(
                        "drama",
                        "romance",
                        "music"
                    ),
                    "English",
                    36000000,
                    433888866
                )
            )
            shows.add(
                ShowsEntity(
                    "Alita: Battle Angle",
                    "@drawable/poster_alita",
                    "2019",
                    "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                    72,
                    arrayListOf(
                        "action",
                        "science",
                        "fiction",
                        "adventure"
                    ),
                    "English",
                    170000000,
                    404852543
                )
            )
            shows.add(
                ShowsEntity(
                    "Aquaman",
                    "@drawable/poster_aquaman",
                    "2018",
                    "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                    69,
                    arrayListOf(
                        "action",
                        "adventure",
                        "fantasy"
                    ),
                    "English",
                    160000000,
                    1148461807
                )
            )
            shows.add(
                ShowsEntity(
                    "Bohemian Rhapsody",
                    "@drawable/poster_bohemian",
                    "2018",
                    "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                    80,
                    arrayListOf(
                        "music",
                        "drama",
                        "history"
                    ),
                    "English",
                    52000000,
                    892027543
                )
            )
            shows.add(
                ShowsEntity(
                    "Cold Pursuit",
                    "@drawable/poster_cold_pursuit",
                    "2019",
                    "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                    57,
                    arrayListOf(
                        "action",
                        "crime",
                        "thriller"
                    ),
                    "English",
                    60000000,
                    76419755
                )
            )
            shows.add(
                ShowsEntity(
                    "Creed II",
                    "@drawable/poster_creed",
                    "2018",
                    "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                    69,
                    arrayListOf(
                        "drama"
                    ),
                    "English",
                    50000000,
                    214215889
                )
            )
            shows.add(
                ShowsEntity(
                    "Fantastic Beasts: The Crimes of Grindelwald",
                    "@drawable/poster_crimes",
                    "2018",
                    "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                    69,
                    arrayListOf(
                        "adventure",
                        "fantasy",
                        "drama"
                    ),
                    "English",
                    200000000,
                    653355901
                )
            )
            shows.add(
                ShowsEntity(
                    "Glass",
                    "@drawable/poster_glass",
                    "2019",
                    "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                    67,
                    arrayListOf(
                        "thriller",
                        "drama",
                        "science fiction"
                    ),
                    "English",
                    20000000,
                    246941965
                )
            )
            shows.add(
                ShowsEntity(
                    "How to Train Your Dragon: The Hidden World",
                    "@drawable/poster_how_to_train",
                    "2019",
                    "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                    78,
                    arrayListOf(
                        "animation",
                        "family",
                        "adventure"
                    ),
                    "English",
                    129000000,
                    512526875
                )
            )
            shows.add(
                ShowsEntity(
                    "Avengers: Infinity War",
                    "@drawable/poster_infinity_war",
                    "2018",
                    "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                    83,
                    arrayListOf(
                        "adventure",
                        "action",
                        "science fiction"
                    ),
                    "English",
                    300000000,
                    2046239637
                )
            )
        }
        else if (showsType == "tv_shows") {
            shows.add(
                ShowsEntity(
                    "Marvel's Iron Fist",
                    "@drawable/poster_iron_fist",
                    "2017",
                    "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                    66,
                    arrayListOf(
                        "action",
                        "adventure",
                        "drama",
                        "fantasy",
                        "science fiction"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "Doom Patrol",
                    "@drawable/poster_doom_patrol",
                    "2019",
                    "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                    76,
                    arrayListOf(
                        "science fiction",
                        "fantasy",
                        "comedy",
                        "drama"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "Dragon Ball",
                    "@drawable/poster_dragon_ball",
                    "2012",
                    "The series begins twelve years after Goku is seen leaving on Shenron not at the end of Dragon Ball GT, and diverges entirely into its own plot from there, on an alternate timeline from the one which shows Goku Jr. fighting Vegeta Jr. at the World Martial Arts Tournament. In this series, Majuub has reached new levels of power, and has honed the techniques taught to him by Goku. We also see Gotenks finally mature, and Vegeta more powerful than ever.Each character will bring forth their own set of capabilities and purpose, winning fights and being relevant, in order to create an environment that emphasizes teamwork as well as individual worth for each character. In this series, the main set of villains are Saiyans, with abilities highly similar to the Saiyans that we are familiar with. These new Saiyans are more powerful than any threat the Z Fighters have ever faced, but after twelve years of intensive training, our heroes will not be easily defeated.",
                    53,
                    arrayListOf(
                        "fantasy"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "Fairy Tail: Dragon Cry",
                    "@drawable/poster_fairytail",
                    "2017",
                    "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
                    65,
                    arrayListOf(
                        "action",
                        "adventure"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "Family Guy",
                    "@drawable/poster_family_guy",
                    "1999",
                    "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                    70,
                    arrayListOf(
                        "animation",
                        "comedy"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "The Flash",
                    "@drawable/poster_flash",
                    "2014",
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only 'meta-human' who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    77,
                    arrayListOf(
                        "drama",
                        "science fiction",
                        "fantasy"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "Shameless",
                    "@drawable/poster_shameless",
                    "2004",
                    "The story of a young group of siblings pretty much abandoned by their parents, surviving by their wits - and humor - on a rough Manchester council estate. Whilst they won't admit it, they need help and find it in Steve, a young middle class lad who falls for Fiona, the oldest sibling, and increasingly finds himself drawn to this unconventional and unique family. Anarchic family life seen through the eyes of an exceptionally bright fifteen year old, who struggles to come of age in the context of his belligerent father, closeted brother, psychotic sister and internet porn star neighbors.",
                    76,
                    arrayListOf(
                        "comedy",
                        "drama"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "Gotham",
                    "@drawable/poster_gotham",
                    "2014",
                    "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                    75,
                    arrayListOf(
                        "drama",
                        "crime",
                        "science fiction",
                        "fantasy"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "Grey's Anatomy",
                    "@drawable/poster_grey_anatomy",
                    "2005",
                    "Follows the personal and professional lives of a group of doctors at Seattle's Grey Sioan Memorial Hospital",
                    82,
                    arrayListOf(
                        "drama"
                    ),
                    "English",
                    null,
                    null
                )
            )
            shows.add(
                ShowsEntity(
                    "Hanna",
                    "@drawable/poster_hanna",
                    "2019",
                    "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright Film.",
                    75,
                    arrayListOf(
                        "action",
                        "adventure",
                        "drama"
                    ),
                    "English",
                    null,
                    null
                )
            )
        }

        return shows
    }
}