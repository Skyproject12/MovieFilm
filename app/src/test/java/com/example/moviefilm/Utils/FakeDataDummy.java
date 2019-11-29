package com.example.moviefilm.Utils;


import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<MovieEntity> generateMovie(){
        ArrayList<MovieEntity> movieEntity = new ArrayList<>();
        movieEntity.add(new MovieEntity(330457,
                "https://image.tmdb.org/t/p/w185/qdfARIhgpgZOBh3vfNhWS4hmSo3.jpg",
                "Frozen II",
                "Elsa, Anna, Kristoff and Olaf are going far in the forest to know the truth about an ancient mystery of their kingdom.",
                "2019-11-20"));
        movieEntity.add(new MovieEntity(429617,
                "https://image.tmdb.org/t/p/w185/lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                "Spider-Man: Far from Home",
                "Peter Parker and his friends go on a summer trip to Europe. However," +
                        " they will hardly be able to rest - Peter will have to agree to help Nick" +
                        " Fury uncover the mystery of creatures that cause natural disasters and " +
                        "destruction throughout the continent.",
                "2019-06-28"));
        movieEntity.add(new MovieEntity(475557,
                "https://image.tmdb.org/t/p/w185/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "Joker",
                "During the 1980s, a failed stand-up comedian is driven insane" +
                        " and turns to a life of crime and chaos in Gotham City while becoming" +
                        " an infamous psychopathic crime figure.",
                "2019-10-02"));

        movieEntity.add(new MovieEntity(420818,
                "https://image.tmdb.org/t/p/w185/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg",
                "The Lion King",
                "Simba idolizes his father, King Mufasa, and takes to heart his own" +
                        " royal destiny. But not everyone in the kingdom celebrates the new cubs" +
                        " arrival. Scar, Mufasa's brother—and former heir to the throne—has plans" +
                        " of his own. The battle for Pride Rock is ravaged with betrayal, tragedy " +
                        "and drama, ultimately resulting in Simba's exile. With help from a curious" +
                        " pair of newfound friends, Simba will have to figure out how to grow up and" +
                        " take back what is rightfully his.",
                "2019-07-12"));

        movieEntity.add(new MovieEntity(466272,
                "https://image.tmdb.org/t/p/w185/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg",
                "Once Upon a Time... in Hollywood",
                "A faded television actor and his stunt double strive to achieve" +
                        " fame and success in the film industry during the final years of " +
                        "Hollywood's Golden Age in 1969 Los Angeles.",
                "2019-07-25"));

        movieEntity.add(new MovieEntity(645541,
                "https://image.tmdb.org/t/p/w185/4I0CQfnMy6sRR7QhgqsXR16TmIs.jpg",
                "Ellipse",
                "A man and his dog are stranded on a volatile, oval-shaped planet and are" +
                        " forced to adapt and escape before time destroys them both.",
                "2019-11-05"));

        movieEntity.add(new MovieEntity(290859,
                "https://image.tmdb.org/t/p/w185/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
                "Terminator: Dark Fate",
                "Decades after Sarah Connor prevented Judgment Day, a lethal new " +
                        "Terminator is sent to eliminate the future leader of the resistance." +
                        " In a fight to save mankind, battle-hardened Sarah Connor teams up " +
                        "with an unexpected ally and an enhanced super soldier to stop the " +
                        "deadliest Terminator yet.",
                "2019-10-23"));

        movieEntity.add(new MovieEntity(474350,
                "https://image.tmdb.org/t/p/w185/zfE0R94v1E8cuKAerbskfD3VfUt.jpg",
                "It Chapter Two",
                "27 years after overcoming the malevolent supernatural entity Pennywise," +
                        " the former members of the Losers' Club, who have grown up and moved away" +
                        " from Derry, are brought back together by a devastating phone call.",
                "2019-09-04"));

        movieEntity.add(new MovieEntity(568012,
                "https://image.tmdb.org/t/p/w185/4E2lyUGLEr3yH4q6kJxPkQUhX7n.jpg",
                "One Piece: Stampede",
                "One Piece: Stampede is a stand-alone film that celebrates the animes" +
                        " 20th Anniversary and takes place outside the canon of the \\\"One Piece\\\"" +
                        " TV series. Monkey D. Luffy and his Straw Hat pirate crew are invited to " +
                        "a massive Pirate Festival that brings many of the most iconic characters" +
                        " from throughout the franchise to participate in competition with the " +
                        "Straw Hats to find Rogers treasure. It also pits the Straw Hats against" +
                        " a new enemy named Bullet, a former member of Rogers crew.",
                "2019-08-09"));

        movieEntity.add(new MovieEntity(453405,
                "https://image.tmdb.org/t/p/w185/uTALxjQU8e1lhmNjP9nnJ3t2pRU.jpg",
                "Gemini Man",
                "Ageing assassin, Henry Brogen tries to get out of the business but" +
                        " finds himself in the ultimate battle—fighting his own clone who is" +
                        " 25 years younger than him, and at the peak of his abilities.",
                "2019-10-02"));

        movieEntity.add(new MovieEntity(480042,
                "https://image.tmdb.org/t/p/w185/r15SUgzjL8bablcdEkHk9T7TSRl.jpg",
                "Escape Plan: The Extractors",
                "After security expert Ray Breslin is hired to rescue the kidnapped " +
                        "daughter of a Hong Kong tech mogul from a formidable Latvian prison," +
                        " Breslin's girlfriend is also captured. Now he and his team must pull" +
                        " off a deadly rescue mission to confront their sadistic foe and save" +
                        " the hostages before time runs out.",
                "2019-06-20"));

        movieEntity.add(new MovieEntity(423204,
                "https://image.tmdb.org/t/p/w185/fapXd3v9qTcNBTm39ZC4KUVQDNf.jpg",
                "Angel Has Fallen",
                "After the events in the previous film, Secret Service agent Mike" +
                        "Banning finds himself framed for an assassination attempt on the " +
                        "President. Pursued by his own agency and the FBI, Banning races to" +
                        " clear his name and uncover the real terrorist threat which has set " +
                        "its sights on Air Force One.",
                "2019-08-21"));

        movieEntity.add(new MovieEntity(920,
                "https://image.tmdb.org/t/p/w185/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg",
                "Cars",
                "Lightning McQueen, a hotshot rookie race car driven to succeed, " +
                        "discovers that life is about the journey, not the finish line, when he" +
                        " finds himself unexpectedly detoured in the sleepy Route 66 town of " +
                        "Radiator Springs. On route across the country to the big Piston Cup " +
                        "Championship in California to compete against two seasoned pros, McQueen" +
                        " gets to know the town's offbeat characters.",
                "2006-06-08"));

        movieEntity.add(new MovieEntity(486589,
                "https://image.tmdb.org/t/p/w185/MBiKqTsouYqAACLYNDadsjhhC0.jpg",
                "Red Shoes 2019",
                "Princes who have been turned into Dwarfs seek the red shoes of a lady" +
                        " in order to break the spell, although it will not be easy.",
                "2019-07-25"));

        movieEntity.add(new MovieEntity(458897,
                "https://image.tmdb.org/t/p/w185/r5WnfZPYAVhBA9FuZGn6THWaGHD.jpg",
                "Charlies Angels",
                "When a systems engineer blows the whistle on a dangerous technology," +
                        " Charlie's Angels from across the globe are called into action, putting" +
                        " their lives on the line to protect society.",
                "2019-11-14"));

        movieEntity.add(new MovieEntity(384018,
                "https://image.tmdb.org/t/p/w185/kvpNZAQow5es1tSY6XW2jAZuPPG.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "Ever since US Diplomatic Security Service Agent Hobbs and lawless outcast" +
                        "Shaw first faced off, they just have swapped smacks and bad words. But when" +
                        " cyber-genetically enhanced anarchist Brixton's ruthless actions threaten the" +
                        " future of humanity, both join forces to defeat him. (A spin-off of “The Fate" +
                        " of the Furious,” focusing on Johnson's Luke Hobbs and Statham's Deckard Shaw.)",
                "2019-08-01"));

        movieEntity.add(new MovieEntity(359724,
                "https://image.tmdb.org/t/p/w185/6ApDtO7xaWAfPqfi2IARXIzj8QS.jpg",
                "Ford v Ferrari",
                "American car designer Carroll Shelby and the British-born driver" +
                        " Ken Miles work together to battle corporate interference, the laws" +
                        " of physics, and their own personal demons to build a revolutionary " +
                        "race car for Ford Motor Company and take on the dominating race cars " +
                        "of Enzo Ferrari at the 24 Hours of Le Mans in France in 1966.",
                "2019-10-10"));

        movieEntity.add(new MovieEntity(449924,
                "https://image.tmdb.org/t/p/w185/vn94LlNrbUWIZZyAdmvUepFBeaY.jpg",
                "葉問4",
                "Ip Man 4 is an upcoming Hong Kong biographical martial arts film" +
                        " directed by Wilson Yip and produced by Raymond Wong. It is the fourth" +
                        " in the Ip Man film series based on the life of the Wing Chun grandmaster" +
                        " of the same name and features Donnie Yen reprising the role. The film " +
                        "began production in April 2018 and ended in July the same year.",
                "2019-12-20"));

        movieEntity.add(new MovieEntity(420817,
                "https://image.tmdb.org/t/p/w185/3iYQTLGoy7QnjcUYRJy4YrAgGvp.jpg",
                "Aladdin",
                "A kindhearted street urchin named Aladdin embarks on a magical adventure" +
                        " after finding a lamp that releases a wisecracking genie while a " +
                        "power-hungry Grand Vizier vies for the same lamp that has the power " +
                        "to make their deepest wishes come true.",
                "2019-05-22"));

        movieEntity.add(new MovieEntity(476631,
                "https://image.tmdb.org/t/p/w185/3HbGrs1V1QS9kxjzPagMZaSxhKK.jpg",
                "Barbie: Dolphin Magic",
                "Barbie and her sisters take off on another exciting, global adventure" +
                        " to visit their friend Ken at his summer internship at a beautiful and" +
                        " exotic coral reef.",
                "2017-10-13"));

        return movieEntity;

    }






    public static ArrayList<TvshowEntity> generateShow(){
        ArrayList<TvshowEntity> show= new ArrayList<>();
        show.add(new TvshowEntity(82856,
                "https://image.tmdb.org/t/p/w185/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg",
                "The Mandalorian",
                "Set after the fall of the Empire and before the emergence of the First Order, we follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic.",
                "2019-11-12"));

        show.add(new TvshowEntity(60625,
                "https://image.tmdb.org/t/p/w185/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
                "Rick and Morty",
                "Rick is a mentally-unbalanced but scientifically-gifted old man " +
                        "who has recently reconnected with his family. He spends most of his " +
                        "time involving his young grandson Morty in dangerous, outlandish " +
                        "adventures throughout space and alternate universes. Compounded " +
                        "with Morty's already unstable family life, these events cause Morty " +
                        "much distress at home and school.",
                "2019-11-12"));

        show.add(new TvshowEntity(1412,
                "https://image.tmdb.org/t/p/w185/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed " +
                        "dead when his yacht is lost at sea. He returns five years later a" +
                        " changed man, determined to clean up the city as a hooded vigilante" +
                        " armed with a bow.",
                "2012-10-10"));

        show.add(new TvshowEntity(71641,
                "https://image.tmdb.org/t/p/w185/jVObyxtNxuPbG5czuKvm7pW56EV.jpg",
                "4 Blocks",
                "Based in Neukölln, Berlin Toni manages the daily business of dealing" +
                        " with the Arabic gangs and ends up wanting to leave his old life behind" +
                        " for his family, but as expected, its never that simple.",
                "2017-05-08"));

        show.add(new TvshowEntity(68507,
                "https://image.tmdb.org/t/p/w185/xOjRNnQw5hqR1EULJ2iHkGwJVA4.jpg",
                "His Dark Materials",
                "Lyra is an orphan who lives in a parallel universe in which " +
                        "science, theology and magic are entwined. Lyra's search for a kidnapped" +
                        " friend uncovers a sinister plot involving stolen children, and turns " +
                        "into a quest to understand a mysterious phenomenon called Dust. She is" +
                        " later joined on her journey by Will, a boy who possesses a knife that " +
                        "can cut windows between worlds. As Lyra learns the truth about her " +
                        "parents and her prophesied destiny, the two young people are caught up" +
                        " in a war against celestial powers that ranges across many worlds.",
                "2019-11-03"));

        show.add(new TvshowEntity(456,
                "https://image.tmdb.org/t/p/w185/yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the" +
                        " antics and everyday adventures of the Simpson family; Homer, Marge, Bart," +
                        " Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning," +
                        " the series has been a pop culture icon, attracting hundreds of celebrities to" +
                        " guest star. The show has also made name for itself in its fearless satirical" +
                        " take on politics, media and American life in general.",
                "1989-12-17"));

        show.add(new TvshowEntity(60735,
                "https://image.tmdb.org/t/p/w185/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator" +
                        " Barry Allen is struck by lightning and falls into a coma. Months later" +
                        " he awakens with the power of super speed, granting him the ability to" +
                        " move through Central City like an unseen guardian angel. Though " +
                        "initially excited by his newfound powers, Barry is shocked to discover " +
                        "he is not the only \\\"meta-human\\\" who was created in the wake" +
                        " of the accelerator explosion -- and not everyone is using their new" +
                        " powers for good. Barry partners with S.T.A.R. Labs and dedicates his" +
                        " life to protect the innocent. For now, only a few close friends and" +
                        " associates know that Barry is literally the fastest man alive, but" +
                        " it won't be long before the world learns what Barry Allen has " +
                        "become...The Flash.",
                "2014-10-07"));

        show.add(new TvshowEntity(1622,
                "https://image.tmdb.org/t/p/w185/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to" +
                        " a mysterious and demonic supernatural force. Subsequently, their " +
                        "father raised them to be soldiers. He taught them about the paranormal" +
                        " evil that lives in the dark corners and on the back roads of America" +
                        " ... and he taught them how to kill it. Now, the Winchester brothers " +
                        "crisscross the country in their '67 Chevy Impala, battling every kind " +
                        "of supernatural threat they encounter along the way.",
                "2005-09-13"));

        show.add(new TvshowEntity(62286,
                "https://image.tmdb.org/t/p/w185/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into" +
                        " the horrifying apocalypse depicted in \\\"The Walking Dead\\\"?" +
                        " This spin-off set in Los Angeles, following new characters as they" +
                        "face the beginning of the end of the world, will answer that question.",
                "2015-08-23"));

        show.add(new TvshowEntity(1416,
                "https://image.tmdb.org/t/p/w185/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                "Greys Anatomy",
                "Follows the personal and professional lives of a group of doctors" +
                        " at Seattle’s Grey Sloan Memorial Hospital.",
                "2005-03-27"));

        show.add(new TvshowEntity(69050,
                "https://image.tmdb.org/t/p/w185/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie," +
                        " Betty, Veronica and their friends, exploring the surreality of small" +
                        "-town life, the darkness and weirdness bubbling beneath Riverdales " +
                        "wholesome facade.",
                "2017-01-26"));

        show.add(new TvshowEntity(2734,
                "https://image.tmdb.org/t/p/w185/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered" +
                        " especially heinous. In New York City, the dedicated detectives who" +
                        " investigate these vicious felonies are members of an elite squad known" +
                        " as the Special Victims Unit. These are their stories.",
                "1999-09-20"));

        show.add(new TvshowEntity(79460,
                "https://image.tmdb.org/t/p/w185/rb64COqdpRRfWOc6gWTfC7WxzXP.jpg",
                "Legacies",
                "In a place where young witches, vampires, and werewolves are nurtured" +
                        " to be their best selves in spite of their worst impulses, Klaus " +
                        "Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzmans " +
                        "twins, Lizzie and Josie Saltzman, among others, come of age into heroes" +
                        " and villains at The Salvatore School for the Young and Gifted.",
                "2018-10-25"));

        show.add(new TvshowEntity(80752,
                "https://image.tmdb.org/t/p/w185/g3JsScc7mQCfc3e5e5rXwu7xVVP.jpg",
                "See",
                "A virus has decimated humankind. Those who survived emerged blind." +
                        " Centuries later when twins are born with the mythic ability to see," +
                        "their father must protect his tribe against a threatened queen.",
                "2019-11-01"));

        show.add(new TvshowEntity(1434,
                "https://image.tmdb.org/t/p/w185/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin Sweet animated series" +
                        " featuring the adventures of the dysfunctional Griffin family. Bumbling" +
                        " Peter and long-suffering Lois have three kids. Stewie (a brilliant but" +
                        " sadistic baby bent on killing his mother and taking over the world)," +
                        " Meg (the oldest, and is the most unpopular girl in town) and Chris " +
                        "(the middle kid, he's not very bright but has a passion for movies). " +
                        "The final member of the family is Brian - a talking dog and much more " +
                        "than a pet, he keeps Stewie in check whilst sipping Martinis and sorting" +
                        " through his own life issues.",
                "1999-01-31"));

        show.add(new TvshowEntity(1402,
                "https://image.tmdb.org/t/p/w185/reKs8y4mPwPkZG99ZpbKRhBPKsX.jpg",
                "The Walking Dead",
                "Sheriffs deputy Rick Grimes awakens from a coma to find a post" +
                        "-apocalyptic world dominated by flesh-eating zombies. He sets out" +
                        " to find his family and encounters many other survivors along the way.",
                "2010-10-31"));

        show.add(new TvshowEntity(46952,
                "https://image.tmdb.org/t/p/w185/bgbQCW4fE9b6wSOSC6Fb4FfVzsW.jpg",
                "The Blacklist",
                "Raymond \\\"Red\\\" Reddington, one of the FBI's most wanted fugitives," +
                        " surrenders in person at FBI Headquarters in Washington, D.C. He claims" +
                        " that he and the FBI have the same interests: bringing down dangerous " +
                        "criminals and terrorists. In the last two decades, he's made a list of " +
                        "criminals and terrorists that matter the most but the FBI cannot find " +
                        "because it does not know they exist. Reddington calls this \\\"The " +
                        "Blacklist\\\". Reddington will co-operate, but insists that he will " +
                        "speak only to Elizabeth Keen, a rookie FBI profiler.",
                "2013-09-23"));

        show.add(new TvshowEntity(1399,
                "https://image.tmdb.org/t/p/w185/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros." +
                        " Friction between the houses leads to full-scale war. All while a very " +
                        "ancient evil awakens in the farthest north. Amidst the war, a neglected" +
                        " military order of misfits, the Night's Watch, is all that stands between" +
                        " the realms of men and icy horrors beyond.",
                "2011-04-17"));

        show.add(new TvshowEntity(2190,
                "https://image.tmdb.org/t/p/w185/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg",
                "South Park",
                "Follows the misadventures of four irreverent grade-schoolers in the quiet" +
                        ", dysfunctional town of South Park, Colorado.",
                "1997-08-13"));

        show.add(new TvshowEntity(57243,
                "https://image.tmdb.org/t/p/w185/3psF5STWO7n9NoXYul27TU8g2GA.jpg",
                "Doctor Who",
                "The Doctor is a Time Lord: a 900 year old alien with 2 hearts, " +
                        "part of a gifted civilization who mastered time travel. The Doctor" +
                        " saves planets for a living—more of a hobby actually, and the Doctors" +
                        " very, very good at it.",
                "2005-03-26"));

        return show;

    }





    public static MovieEntity getIdMovie(int movieId){
        for (int i=0; i<generateMovie().size();i++){
            MovieEntity movieEntity = generateMovie().get(i);
            if(movieEntity.getId()==movieId){
                return movieEntity;
            }
        }
        return null;

    }




    public static TvshowEntity getIdShow(int show){
        for (int i=0; i<generateShow().size();i++){
            TvshowEntity movie= generateShow().get(i);
            if(movie.getId()==show){
                return movie;
            }
        }
        return null;

    }





    public static ArrayList<MovieResponse> generateMovieResponse(){
        ArrayList<MovieResponse> movie= new ArrayList<>();
        movie.add(new MovieResponse(330457,
                "https://image.tmdb.org/t/p/w185/qdfARIhgpgZOBh3vfNhWS4hmSo3.jpg",
                "Frozen II",
                "Elsa, Anna, Kristoff and Olaf are going far in the forest to know the truth about an ancient mystery of their kingdom.",
                "2019-11-20"));
        movie.add(new MovieResponse(429617,
                "https://image.tmdb.org/t/p/w185/lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                "Spider-Man: Far from Home",
                "Peter Parker and his friends go on a summer trip to Europe. However," +
                        " they will hardly be able to rest - Peter will have to agree to help Nick" +
                        " Fury uncover the mystery of creatures that cause natural disasters and " +
                        "destruction throughout the continent.",
                "2019-06-28"));
        movie.add(new MovieResponse(475557,
                "https://image.tmdb.org/t/p/w185/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "Joker",
                "During the 1980s, a failed stand-up comedian is driven insane" +
                        " and turns to a life of crime and chaos in Gotham City while becoming" +
                        " an infamous psychopathic crime figure.",
                "2019-10-02"));

        movie.add(new MovieResponse(420818,
                "https://image.tmdb.org/t/p/w185/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg",
                "The Lion King",
                "Simba idolizes his father, King Mufasa, and takes to heart his own" +
                        " royal destiny. But not everyone in the kingdom celebrates the new cubs" +
                        " arrival. Scar, Mufasa's brother—and former heir to the throne—has plans" +
                        " of his own. The battle for Pride Rock is ravaged with betrayal, tragedy " +
                        "and drama, ultimately resulting in Simba's exile. With help from a curious" +
                        " pair of newfound friends, Simba will have to figure out how to grow up and" +
                        " take back what is rightfully his.",
                "2019-07-12"));

        movie.add(new MovieResponse(466272,
                "https://image.tmdb.org/t/p/w185/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg",
                "Once Upon a Time... in Hollywood",
                "A faded television actor and his stunt double strive to achieve" +
                        " fame and success in the film industry during the final years of " +
                        "Hollywood's Golden Age in 1969 Los Angeles.",
                "2019-07-25"));

        movie.add(new MovieResponse(645541,
                "https://image.tmdb.org/t/p/w185/4I0CQfnMy6sRR7QhgqsXR16TmIs.jpg",
                "Ellipse",
                "A man and his dog are stranded on a volatile, oval-shaped planet and are" +
                        " forced to adapt and escape before time destroys them both.",
                "2019-11-05"));

        movie.add(new MovieResponse(290859,
                "https://image.tmdb.org/t/p/w185/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
                "Terminator: Dark Fate",
                "Decades after Sarah Connor prevented Judgment Day, a lethal new " +
                        "Terminator is sent to eliminate the future leader of the resistance." +
                        " In a fight to save mankind, battle-hardened Sarah Connor teams up " +
                        "with an unexpected ally and an enhanced super soldier to stop the " +
                        "deadliest Terminator yet.",
                "2019-10-23"));

        movie.add(new MovieResponse(474350,
                "https://image.tmdb.org/t/p/w185/zfE0R94v1E8cuKAerbskfD3VfUt.jpg",
                "It Chapter Two",
                "27 years after overcoming the malevolent supernatural entity Pennywise," +
                        " the former members of the Losers' Club, who have grown up and moved away" +
                        " from Derry, are brought back together by a devastating phone call.",
                "2019-09-04"));

        movie.add(new MovieResponse(568012,
                "https://image.tmdb.org/t/p/w185/4E2lyUGLEr3yH4q6kJxPkQUhX7n.jpg",
                "One Piece: Stampede",
                "One Piece: Stampede is a stand-alone film that celebrates the animes" +
                        " 20th Anniversary and takes place outside the canon of the \\\"One Piece\\\"" +
                        " TV series. Monkey D. Luffy and his Straw Hat pirate crew are invited to " +
                        "a massive Pirate Festival that brings many of the most iconic characters" +
                        " from throughout the franchise to participate in competition with the " +
                        "Straw Hats to find Rogers treasure. It also pits the Straw Hats against" +
                        " a new enemy named Bullet, a former member of Rogers crew.",
                "2019-08-09"));

        movie.add(new MovieResponse(453405,
                "https://image.tmdb.org/t/p/w185/uTALxjQU8e1lhmNjP9nnJ3t2pRU.jpg",
                "Gemini Man",
                "Ageing assassin, Henry Brogen tries to get out of the business but" +
                        " finds himself in the ultimate battle—fighting his own clone who is" +
                        " 25 years younger than him, and at the peak of his abilities.",
                "2019-10-02"));

        movie.add(new MovieResponse(480042,
                "https://image.tmdb.org/t/p/w185/r15SUgzjL8bablcdEkHk9T7TSRl.jpg",
                "Escape Plan: The Extractors",
                "After security expert Ray Breslin is hired to rescue the kidnapped " +
                        "daughter of a Hong Kong tech mogul from a formidable Latvian prison," +
                        " Breslin's girlfriend is also captured. Now he and his team must pull" +
                        " off a deadly rescue mission to confront their sadistic foe and save" +
                        " the hostages before time runs out.",
                "2019-06-20"));

        movie.add(new MovieResponse(423204,
                "https://image.tmdb.org/t/p/w185/fapXd3v9qTcNBTm39ZC4KUVQDNf.jpg",
                "Angel Has Fallen",
                "After the events in the previous film, Secret Service agent Mike" +
                        "Banning finds himself framed for an assassination attempt on the " +
                        "President. Pursued by his own agency and the FBI, Banning races to" +
                        " clear his name and uncover the real terrorist threat which has set " +
                        "its sights on Air Force One.",
                "2019-08-21"));

        movie.add(new MovieResponse(920,
                "https://image.tmdb.org/t/p/w185/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg",
                "Cars",
                "Lightning McQueen, a hotshot rookie race car driven to succeed, " +
                        "discovers that life is about the journey, not the finish line, when he" +
                        " finds himself unexpectedly detoured in the sleepy Route 66 town of " +
                        "Radiator Springs. On route across the country to the big Piston Cup " +
                        "Championship in California to compete against two seasoned pros, McQueen" +
                        " gets to know the town's offbeat characters.",
                "2006-06-08"));

        movie.add(new MovieResponse(486589,
                "https://image.tmdb.org/t/p/w185/MBiKqTsouYqAACLYNDadsjhhC0.jpg",
                "Red Shoes 2019",
                "Princes who have been turned into Dwarfs seek the red shoes of a lady" +
                        " in order to break the spell, although it will not be easy.",
                "2019-07-25"));

        movie.add(new MovieResponse(458897,
                "https://image.tmdb.org/t/p/w185/r5WnfZPYAVhBA9FuZGn6THWaGHD.jpg",
                "Charlies Angels",
                "When a systems engineer blows the whistle on a dangerous technology," +
                        " Charlie's Angels from across the globe are called into action, putting" +
                        " their lives on the line to protect society.",
                "2019-11-14"));

        movie.add(new MovieResponse(384018,
                "https://image.tmdb.org/t/p/w185/kvpNZAQow5es1tSY6XW2jAZuPPG.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "Ever since US Diplomatic Security Service Agent Hobbs and lawless outcast" +
                        "Shaw first faced off, they just have swapped smacks and bad words. But when" +
                        " cyber-genetically enhanced anarchist Brixton's ruthless actions threaten the" +
                        " future of humanity, both join forces to defeat him. (A spin-off of “The Fate" +
                        " of the Furious,” focusing on Johnson's Luke Hobbs and Statham's Deckard Shaw.)",
                "2019-08-01"));

        movie.add(new MovieResponse(359724,
                "https://image.tmdb.org/t/p/w185/6ApDtO7xaWAfPqfi2IARXIzj8QS.jpg",
                "Ford v Ferrari",
                "American car designer Carroll Shelby and the British-born driver" +
                        " Ken Miles work together to battle corporate interference, the laws" +
                        " of physics, and their own personal demons to build a revolutionary " +
                        "race car for Ford Motor Company and take on the dominating race cars " +
                        "of Enzo Ferrari at the 24 Hours of Le Mans in France in 1966.",
                "2019-10-10"));

        movie.add(new MovieResponse(449924,
                "https://image.tmdb.org/t/p/w185/vn94LlNrbUWIZZyAdmvUepFBeaY.jpg",
                "葉問4",
                "Ip Man 4 is an upcoming Hong Kong biographical martial arts film" +
                        " directed by Wilson Yip and produced by Raymond Wong. It is the fourth" +
                        " in the Ip Man film series based on the life of the Wing Chun grandmaster" +
                        " of the same name and features Donnie Yen reprising the role. The film " +
                        "began production in April 2018 and ended in July the same year.",
                "2019-12-20"));

        movie.add(new MovieResponse(420817,
                "https://image.tmdb.org/t/p/w185/3iYQTLGoy7QnjcUYRJy4YrAgGvp.jpg",
                "Aladdin",
                "A kindhearted street urchin named Aladdin embarks on a magical adventure" +
                        " after finding a lamp that releases a wisecracking genie while a " +
                        "power-hungry Grand Vizier vies for the same lamp that has the power " +
                        "to make their deepest wishes come true.",
                "2019-05-22"));

        movie.add(new MovieResponse(476631,
                "https://image.tmdb.org/t/p/w185/3HbGrs1V1QS9kxjzPagMZaSxhKK.jpg",
                "Barbie: Dolphin Magic",
                "Barbie and her sisters take off on another exciting, global adventure" +
                        " to visit their friend Ken at his summer internship at a beautiful and" +
                        " exotic coral reef.",
                "2017-10-13"));

        return movie;

    }






    public static ArrayList<TvShowResponse> generateShowResponse(){
        ArrayList<TvShowResponse> show= new ArrayList<>();
        show.add(new TvShowResponse(82856,
                "https://image.tmdb.org/t/p/w185/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg",
                "The Mandalorian",
                "Set after the fall of the Empire and before the emergence of the First Order, we follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic.",
                "2019-11-12"));

        show.add(new TvShowResponse(60625,
                "https://image.tmdb.org/t/p/w185/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
                "Rick and Morty",
                "Rick is a mentally-unbalanced but scientifically-gifted old man " +
                        "who has recently reconnected with his family. He spends most of his " +
                        "time involving his young grandson Morty in dangerous, outlandish " +
                        "adventures throughout space and alternate universes. Compounded " +
                        "with Morty's already unstable family life, these events cause Morty " +
                        "much distress at home and school.",
                "2019-11-12"));

        show.add(new TvShowResponse(1412,
                "https://image.tmdb.org/t/p/w185/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed " +
                        "dead when his yacht is lost at sea. He returns five years later a" +
                        " changed man, determined to clean up the city as a hooded vigilante" +
                        " armed with a bow.",
                "2012-10-10"));

        show.add(new TvShowResponse(71641,
                "https://image.tmdb.org/t/p/w185/jVObyxtNxuPbG5czuKvm7pW56EV.jpg",
                "4 Blocks",
                "Based in Neukölln, Berlin Toni manages the daily business of dealing" +
                        " with the Arabic gangs and ends up wanting to leave his old life behind" +
                        " for his family, but as expected, its never that simple.",
                "2017-05-08"));

        show.add(new TvShowResponse(68507,
                "https://image.tmdb.org/t/p/w185/xOjRNnQw5hqR1EULJ2iHkGwJVA4.jpg",
                "His Dark Materials",
                "Lyra is an orphan who lives in a parallel universe in which " +
                        "science, theology and magic are entwined. Lyra's search for a kidnapped" +
                        " friend uncovers a sinister plot involving stolen children, and turns " +
                        "into a quest to understand a mysterious phenomenon called Dust. She is" +
                        " later joined on her journey by Will, a boy who possesses a knife that " +
                        "can cut windows between worlds. As Lyra learns the truth about her " +
                        "parents and her prophesied destiny, the two young people are caught up" +
                        " in a war against celestial powers that ranges across many worlds.",
                "2019-11-03"));

        show.add(new TvShowResponse(456,
                "https://image.tmdb.org/t/p/w185/yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the" +
                        " antics and everyday adventures of the Simpson family; Homer, Marge, Bart," +
                        " Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning," +
                        " the series has been a pop culture icon, attracting hundreds of celebrities to" +
                        " guest star. The show has also made name for itself in its fearless satirical" +
                        " take on politics, media and American life in general.",
                "1989-12-17"));

        show.add(new TvShowResponse(60735,
                "https://image.tmdb.org/t/p/w185/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator" +
                        " Barry Allen is struck by lightning and falls into a coma. Months later" +
                        " he awakens with the power of super speed, granting him the ability to" +
                        " move through Central City like an unseen guardian angel. Though " +
                        "initially excited by his newfound powers, Barry is shocked to discover " +
                        "he is not the only \\\"meta-human\\\" who was created in the wake" +
                        " of the accelerator explosion -- and not everyone is using their new" +
                        " powers for good. Barry partners with S.T.A.R. Labs and dedicates his" +
                        " life to protect the innocent. For now, only a few close friends and" +
                        " associates know that Barry is literally the fastest man alive, but" +
                        " it won't be long before the world learns what Barry Allen has " +
                        "become...The Flash.",
                "2014-10-07"));

        show.add(new TvShowResponse(1622,
                "https://image.tmdb.org/t/p/w185/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to" +
                        " a mysterious and demonic supernatural force. Subsequently, their " +
                        "father raised them to be soldiers. He taught them about the paranormal" +
                        " evil that lives in the dark corners and on the back roads of America" +
                        " ... and he taught them how to kill it. Now, the Winchester brothers " +
                        "crisscross the country in their '67 Chevy Impala, battling every kind " +
                        "of supernatural threat they encounter along the way.",
                "2005-09-13"));

        show.add(new TvShowResponse(62286,
                "https://image.tmdb.org/t/p/w185/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into" +
                        " the horrifying apocalypse depicted in \\\"The Walking Dead\\\"?" +
                        " This spin-off set in Los Angeles, following new characters as they" +
                        "face the beginning of the end of the world, will answer that question.",
                "2015-08-23"));

        show.add(new TvShowResponse(1416,
                "https://image.tmdb.org/t/p/w185/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                "Greys Anatomy",
                "Follows the personal and professional lives of a group of doctors" +
                        " at Seattle’s Grey Sloan Memorial Hospital.",
                "2005-03-27"));

        show.add(new TvShowResponse(69050,
                "https://image.tmdb.org/t/p/w185/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie," +
                        " Betty, Veronica and their friends, exploring the surreality of small" +
                        "-town life, the darkness and weirdness bubbling beneath Riverdales " +
                        "wholesome facade.",
                "2017-01-26"));

        show.add(new TvShowResponse(2734,
                "https://image.tmdb.org/t/p/w185/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered" +
                        " especially heinous. In New York City, the dedicated detectives who" +
                        " investigate these vicious felonies are members of an elite squad known" +
                        " as the Special Victims Unit. These are their stories.",
                "1999-09-20"));

        show.add(new TvShowResponse(79460,
                "https://image.tmdb.org/t/p/w185/rb64COqdpRRfWOc6gWTfC7WxzXP.jpg",
                "Legacies",
                "In a place where young witches, vampires, and werewolves are nurtured" +
                        " to be their best selves in spite of their worst impulses, Klaus " +
                        "Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzmans " +
                        "twins, Lizzie and Josie Saltzman, among others, come of age into heroes" +
                        " and villains at The Salvatore School for the Young and Gifted.",
                "2018-10-25"));

        show.add(new TvShowResponse(80752,
                "https://image.tmdb.org/t/p/w185/g3JsScc7mQCfc3e5e5rXwu7xVVP.jpg",
                "See",
                "A virus has decimated humankind. Those who survived emerged blind." +
                        " Centuries later when twins are born with the mythic ability to see," +
                        "their father must protect his tribe against a threatened queen.",
                "2019-11-01"));

        show.add(new TvShowResponse(1434,
                "https://image.tmdb.org/t/p/w185/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin Sweet animated series" +
                        " featuring the adventures of the dysfunctional Griffin family. Bumbling" +
                        " Peter and long-suffering Lois have three kids. Stewie (a brilliant but" +
                        " sadistic baby bent on killing his mother and taking over the world)," +
                        " Meg (the oldest, and is the most unpopular girl in town) and Chris " +
                        "(the middle kid, he's not very bright but has a passion for movies). " +
                        "The final member of the family is Brian - a talking dog and much more " +
                        "than a pet, he keeps Stewie in check whilst sipping Martinis and sorting" +
                        " through his own life issues.",
                "1999-01-31"));

        show.add(new TvShowResponse(1402,
                "https://image.tmdb.org/t/p/w185/reKs8y4mPwPkZG99ZpbKRhBPKsX.jpg",
                "The Walking Dead",
                "Sheriffs deputy Rick Grimes awakens from a coma to find a post" +
                        "-apocalyptic world dominated by flesh-eating zombies. He sets out" +
                        " to find his family and encounters many other survivors along the way.",
                "2010-10-31"));

        show.add(new TvShowResponse(46952,
                "https://image.tmdb.org/t/p/w185/bgbQCW4fE9b6wSOSC6Fb4FfVzsW.jpg",
                "The Blacklist",
                "Raymond \\\"Red\\\" Reddington, one of the FBI's most wanted fugitives," +
                        " surrenders in person at FBI Headquarters in Washington, D.C. He claims" +
                        " that he and the FBI have the same interests: bringing down dangerous " +
                        "criminals and terrorists. In the last two decades, he's made a list of " +
                        "criminals and terrorists that matter the most but the FBI cannot find " +
                        "because it does not know they exist. Reddington calls this \\\"The " +
                        "Blacklist\\\". Reddington will co-operate, but insists that he will " +
                        "speak only to Elizabeth Keen, a rookie FBI profiler.",
                "2013-09-23"));

        show.add(new TvShowResponse(1399,
                "https://image.tmdb.org/t/p/w185/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros." +
                        " Friction between the houses leads to full-scale war. All while a very " +
                        "ancient evil awakens in the farthest north. Amidst the war, a neglected" +
                        " military order of misfits, the Night's Watch, is all that stands between" +
                        " the realms of men and icy horrors beyond.",
                "2011-04-17"));

        show.add(new TvShowResponse(2190,
                "https://image.tmdb.org/t/p/w185/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg",
                "South Park",
                "Follows the misadventures of four irreverent grade-schoolers in the quiet" +
                        ", dysfunctional town of South Park, Colorado.",
                "1997-08-13"));

        show.add(new TvShowResponse(57243,
                "https://image.tmdb.org/t/p/w185/3psF5STWO7n9NoXYul27TU8g2GA.jpg",
                "Doctor Who",
                "The Doctor is a Time Lord: a 900 year old alien with 2 hearts, " +
                        "part of a gifted civilization who mastered time travel. The Doctor" +
                        " saves planets for a living—more of a hobby actually, and the Doctors" +
                        " very, very good at it.",
                "2005-03-26"));

        return show;

    }


    public static ArrayList<MovieResponse> getMovieResponseId(int movieId){
        for (int i=0; i<generateMovie().size();i++){
            MovieResponse movie= generateMovieResponse().get(i);
            ArrayList<MovieResponse> array= new ArrayList<>();
            array.add(movie);
            if(movie.getId()==movieId){
                return array;
            }
        }
        return null;

    }




    public static ArrayList<TvShowResponse> getShowResponseId(int show){
        for (int i=0; i<generateShow().size();i++){
            TvShowResponse movie= generateShowResponse().get(i);
            ArrayList<TvShowResponse> array= new ArrayList<>();
            array.add(movie);
            if(movie.getId()==show){
                return array;
            }
        }
        return null;

    }

}
