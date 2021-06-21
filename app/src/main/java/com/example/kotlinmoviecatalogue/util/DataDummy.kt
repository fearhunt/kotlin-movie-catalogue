package com.example.kotlinmoviecatalogue.util

import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.data.source.remote.response.*
import okhttp3.internal.immutableListOf
import java.util.*

object DataDummy {
    fun generateDummy(showsType: String): ArrayList<ShowsEntity> {
        val results = ArrayList<ShowsEntity>()

        if (showsType == "movies") {
            results.add(
                ShowsEntity(
                    337404,
                    "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                    "en",
                    "Cruella",
                    null,
                    "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    423108,
                    "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                    "en",
                    "The Conjuring: The Devil Made Me Do It",
                    null,
                    "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    637649,
                    "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                    "en",
                    "Wrath of Man",
                    null,
                    "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    717192,
                    "Before he built a drug empire, Ferry Bouman returns to his hometown on a revenge mission that finds his loyalty tested — and a love that alters his life.",
                    "nl",
                    "Ferry",
                    null,
                    "/w6n1pu9thpCVHILejsuhKf3tNCV.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    460465,
                    "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                    "en",
                    "Mortal Kombat",
                    null,
                    "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    804435,
                    "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                    "en",
                    "Vanquish",
                    null,
                    "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    726429,
                    "Two years after the murder of his son and father, a retired hitman sets in motion a carefully crafted revenge plan against the killer: his own brother.",
                    "es",
                    "Xtreme",
                    null,
                    "/cwUhVcDeMYYeu8fq5q1OPOoSbZ7.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    503736,
                    "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                    "en",
                    "Army of the Dead",
                    null,
                    "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    817451,
                    "Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya. But as they venture off alone into a wilderness park, their safari van is flipped over by an angry rhino, leaving them injured and desperate. Then, as two of them go in search of rescue, a bloody, vicious encounter with a leopard and a clan of hyenas incites a desperate fight for survival.",
                    "en",
                    "Endangered Species",
                    null,
                    "/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    399566,
                    "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                    "en",
                    "Godzilla vs. Kong",
                    null,
                    "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    567189,
                    "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                    "en",
                    "Tom Clancy's Without Remorse",
                    null,
                    "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    632357,
                    "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                    "en",
                    "The Unholy",
                    null,
                    "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    520763,
                    "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
                    "en",
                    "A Quiet Place Part II",
                    null,
                    "/4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    602734,
                    "Working in the shadow of an esteemed police veteran, brash Detective Ezekiel “Zeke” Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city’s gruesome past.  Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer’s morbid game.",
                    "en",
                    "Spiral: From the Book of Saw",
                    null,
                    "/lcyKve7nXRFgRyms9M1bndNkKOx.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    808023,
                    "A lonesome stranger with nerves of steel must track down and kill a rogue hitman to satisfy an outstanding debt. But the only information he's been given is a time and location where to find his quarry. No name. No description. Nothing.",
                    "en",
                    "The Virtuoso",
                    null,
                    "/vXHzO26mJaOt4VO7ZFiM6No5ScT.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    578701,
                    "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                    "en",
                    "Those Who Wish Me Dead",
                    null,
                    "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    615457,
                    "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                    "en",
                    "Nobody",
                    null,
                    "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    823855,
                    "A special crimes investigator forms an unlikely bond with a serial killer to bring down a global child sex trafficking syndicate.",
                    "en",
                    "I Am All Girls",
                    null,
                    "/m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    791373,
                    "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                    "en",
                    "Zack Snyder's Justice League",
                    null,
                    "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    615678,
                    "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                    "en",
                    "Thunder Force",
                    null,
                    "/3mKMWP5OokB7QpcOMA1yl8BXFAF.jpg",
                    isFavorite = false
                )
            )
        } else if (showsType == "tv_shows") {
            results.add(
                ShowsEntity(
                    84958,
                    "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                    "en",
                    null,
                    "Loki",
                    "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    103768,
                    "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
                    "en",
                    null,
                    "Sweet Tooth",
                    "/rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    63174,
                    "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                    "en",
                    null,
                    "Lucifer",
                    "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    60735,
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    "en",
                    null,
                    "The Flash",
                    "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    71712,
                    "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                    "en",
                    null,
                    "The Good Doctor",
                    "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    88396,
                    "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                    "en",
                    null,
                    "The Falcon and the Winter Soldier",
                    "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                    isFavorite = true
                )
            )

            results.add(
                ShowsEntity(
                    1416,
                    "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                    "en",
                    null,
                    "Grey's Anatomy",
                    "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    91557,
                    "A small Norwegian town experiencing warm winters and violent downpours seems to be headed for another Ragnarök -- unless someone intervenes in time.",
                    "no",
                    null,
                    "Ragnarok",
                    "/xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    96677,
                    "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                    "fr",
                    null,
                    "Lupin",
                    "/sgxawbFB5Vi5OkPWQLNfl3dvkNJ.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    76669,
                    "When three working class kids enroll in the most exclusive school in Spain, the clash between the wealthy and the poor students leads to tragedy.",
                    "es",
                    null,
                    "Elite",
                    "/3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    95057,
                    "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                    "en",
                    null,
                    "Superman & Lois",
                    "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    62286,
                    "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                    "en",
                    null,
                    "Fear the Walking Dead",
                    "/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    69050,
                    "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                    "en",
                    null,
                    "Riverdale",
                    "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    80240,
                    "After spending seventeen years in prison unfairly, a talented songwriter seeks revenge on the men who sank her and killed her family.",
                    "es",
                    null,
                    "The Queen of Flow",
                    "/fuVuDYrs8sxvEolnYr0wCSvtyTi.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    95557,
                    "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                    "en",
                    null,
                    "Invincible",
                    "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    85271,
                    "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                    "en",
                    null,
                    "WandaVision",
                    "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    1399,
                    "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                    "en",
                    null,
                    "Game of Thrones",
                    "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    120168,
                    "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                    "es",
                    null,
                    "Who Killed Sara?",
                    "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    79460,
                    "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                    "en",
                    null,
                    "Legacies",
                    "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                    isFavorite = false
                )
            )

            results.add(
                ShowsEntity(
                    69478,
                    "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel.",
                    "en",
                    null,
                    "The Handmaid's Tale",
                    "/oIkxqt6ug5zT5ZSUUyc1Iqopf02.jpg",
                    isFavorite = false
                )
            )
        }

        return results
    }

    fun generateDetailDummy(showsType: String): ShowsEntity {
        return if (showsType == "movies") {
            ShowsEntity(
                337404,
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "en",
                "Cruella",
                null,
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "/8ChCpCYxh9YXusmHwcE9YzP0TSG.jpg",
                129300000,
                200000000,
                "2021-05-26",
                null,
                8.6,
                "Comedy, Crime",
            )
        } else {
            ShowsEntity(
                1416,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "en",
                null,
                "Grey's Anatomy",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                null,
                null,
                null,
                "2005-03-27",
                8.2,
                "Drama",
            )
        }
    }
}