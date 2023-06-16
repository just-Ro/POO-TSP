package ant_colony_optimization;

import rand.CustomRandom;
import rand.RandomSingleton;

/**
 * This class represents a collection of names.
 * It provides functionality to access a random name from the collection.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Names implements INames{

    private static Names instance;
    private static boolean defined = false;

    private static String[] names = {
        "James", "John", "Robert", "Michael", "William", "David", "Joseph", "Charles", "Thomas",
        "Daniel", "Matthew", "George", "Andrew Tate", "Edward", "Henry", "Patrick", "Richard",
        "Benjamin", "Peter", "Stephen", "Paul", "Frank", "Anthony", "Kenneth", "Steven", "Brian",
        "Kevin", "Jason", "Timothy", "Joshua", "Eric", "Jeremy", "Adam", "Scott", "Jonathan", "Gregory",
        "Justin", "Terry", "Keith", "Raymond", "Alexander", "Jesse", "Dennis", "Brandon", "Mark",
        "Aaron", "Travis Scott", "Jeffrey", "Ryan", "Samuel", "Nathan", "Eragon", "Joe",
        "Bryan", "Philip", "Shawn", "Larry", "Dylan", "Roger", "Harry", "Oliver",
        "Jack", "Arthur", "Jacob", "Leo", "Oscar", "Freddie", "Alfie", "Ryan Reynolds",
        "Charlie", "Theodore", "Muhammad", "Archie", "Steve", "Arya", "Eminem",
        "Max", "Mason", "Ethan", "Noah", "Mary", "Jennifer", "Linda", "Boris",
        "Patricia", "Elizabeth", "Susan", "Jessica", "Sarah", "Karen", "Rihanna",
        "Nancy", "Lisa", "Betty", "Dorothy", "Sandra", "Ashley", "Kimberly", "Donna", "Emily",
        "Michelle", "Carol", "Amanda", "Melissa", "Deborah", "Stephanie", "Rebecca", "Laura", "Helen",
        "Sharon", "Cynthia", "Kathleen", "Amy", "Anna", "Brenda", "Pamela", "Nicole", "Christine",
        "Victoria", "Catherine", "Janet", "Martha", "Megan", "Julia", "Sara", "Angela", "Teresa",
        "Evelyn", "Maria", "Diana", "Heather", "Rachel", "Frances", "Joyce", "Gloria",
        "Virginia", "Cassandra", "Tracy", "Rita", "Judy", "Wanda", "Sophia", "Olivia", "Lily", "Mia",
        "Isabella", "Amelia", "Ava", "Harper", "Abigail", "Charlotte", "Ibrahimovic", "Cristiano Ronaldo",
        "Chloe", "Zoe", "Ella", "Grace", "Scarlett", "Hannah", "Layla", "Nora", "Lionel Messi",
        "Adney", "Aldo", "Aleyn", "Alford", "Amherst", "Angel", "Anson", "Archibald", "Aries", "Arwen",
        "Astin", "Atley", "Atwell", "Audie", "Avery", "Ayers", "Baker", "Balder", "Ballentine", "Bardalph",
        "Barker", "Barric", "Bayard", "Bishop", "Blaan", "Blackburn", "Blade", "Blaine", "Blaze", "Bramwell", "Brant",
        "Brawley", "Breri", "Briar", "Brighton", "Broderick", "Bronson", "Bryce", "Burdette", "Burle", "Byrd", "Byron",
        "Cabal", "Cage", "Cahir", "Cavalon", "Cedar", "Chatillon", "Churchill", "Clachas", "Addison", "Alivia", "Allaya",
        "Amarie", "Amaris", "Annabeth", "Annalynn", "Araminta", "Ardys", "Ashland", "Avery", "Bedegrayne",
        "Bernadette", "Billie Eilish", "Birdee", "Bliss", "Brice", "Brittany", "Bryony", "Cameo", "Carol", "Chalee",
        "Christy", "Corky", "Cotovatre", "Courage", "Daelen", "Dana", "Darnell", "Dawn", "Delsie", "Denita",
        "Devon", "Devona", "Diamond", "Divinity", "Duff", "Dustin", "Dusty", "Eren", "Eppie",
        "Everilda", "Falynn", "Fanny", "Faren", "Freedom", "Shane", "Lady Gaga",
        "Cleavant", "Cleomenes", "Cloten", "Colson", "Colton", "Crandall", "Cupid", "Curio", "Dacian",
        "Dack", "Daelen", "Dagonet", "Dailan", "Dakin", "Dallin", "Dalton", "Dartmouth", "Dathan",
        "Dawson", "Dax", "Deandre", "Demarco", "Denton", "Denver", "Denzel", "Derward", "Diamond", "Dickinson",
        "Dillard", "Doane", "Doc", "Draper", "Dugan", "Dunley", "Dunn", "Dunstan", "Dwyer", "Dyson", "Ebony",
        "Edison", "Edred", "Edwy", "Egbert", "Eldwin", "Elgin", "Ellis", "Elwood", "Emmett", "Errol", "Escalus",
        "Germain", "Gig", "Gilda", "Giselle", "Githa", "Haiden", "Halston", "Henna", "Honey", "Iblis",
        "Idalis", "Ilsa", "Jersey", "Jette", "Jill", "Jo Beth", "Joanna", "Kachelle", "Kade", "Kady", "Kaela",
        "Kalyn", "Kandice", "Karrie", "Karyn", "Katiuscia", "Kempley", "Kenda", "Kennice", "Kenyon", "Kiandra", "Kimber",
        "Kimn", "Kinsey", "Kipling", "Kipp", "Kismet", "Kolton", "Kordell", "Kortney", "Kourtney", "Kristal",
        "Kylar", "Ladawn", "Ladye", "Lainey", "Lara", "Larkin", "Larson", "Lashanda",
        "Lashawn", "Lashay", "Laurice", "Lawrence", "Layton", "Ethelbert",
        "Ethelred", "Ethelwolf", "Everest", "Ewing", "Falkner", "Falstaff", "Farnell", "Farold",
        "Farran", "Fenton", "Finch", "Fitz", "Fleming", "Flint", "Fox", "Freedom", "Freyr", "Frollo",
        "Gaines", "Gale", "Gallant", "Gamel", "Garfield", "Garrett", "Geary", "Gene", "Gifford", "Gildas",
        "Gomer", "Graham", "Grand", "Green", "Gremio", "Gresham", "Griffin", "Grover", "Grumio", "Guard",
        "Guildenstern", "Guinness", "Hart", "Haskel", "Heathcliff", "Heaton", "Helmut", "Herring", "Herve", "Hickory", "Houston",
        "Landen", "Landon", "Landry", "Laney", "Langley", "Lanna", "Laquetta", "Lari", "Lark", "Laurel", "Lavender", "Leane",
        "LeAnn", "Leanna", "Leanne", "Leanore", "Lee", "Leeann", "Leighanna", "Lexie", "Lexis", "Liberty", "Liliana", "Lillian",
        "Lindley", "Linne", "Liora", "Lisabet", "Liz", "Lizette", "Lona", "London", "Loni", "Lorena", "Loretta", "Lovette",
        "Lynde", "Lyndon", "Lyndsay", "Lynette", "Lynley", "Lynna", "Lynton", "Mada", "Maddox",
        "Madison", "Mae", "Magdalene", "Malin", "Manette",
        "Howard", "Howe", "Hoyt", "Hurst", "Huxley", "Indiana", "Innocent", "Jagger", "Jarrell", "Jax",
        "Jaxon", "Jay", "Jet", "Judson", "Julian", "Kaid", "Keane", "Keaton", "Kell", "Kelsey", "Kelvin",
        "Maitane", "Maitland", "Malachite", "Mamie", "Manhattan", "Maridel", "Marla", "Marliss", "Maud",
        "May", "Merleen", "Mersadize", "Mildred", "Milissa", "Millicent", "Mily", "Mopsa", "Mykala", "Nan",
        "Nautica", "Nelda", "Niki", "Nikole", "Nimue", "Nineve", "Norina", "Ofa", "Palmer", "Pansy",
        "Paris", "Patience", "Peony", "Petunia", "Pixie", "Pleasance", "Polly", "Primrose", "Princell",
        "Providence", "Purity", "Quanah", "Queena", "Quella", "Quinci", "Rae", "Raina", "Raven", "Ray",
        "Rayleen", "Raymond", "Rayna", "Reba", "Rebecca", "Rebekah", "Regan", "Regina", "Reilly", "Reina",
        "Reinaldo", "Reinhold", "Remington", "Remy", "Rena", "Renae", "Renaldo", "Renard", "Renata", "Renato",
        "Rene", "Renea", "Renee", "Renita", "Renna", "Rennie", "Reno", "Reta", "Retha", "Retta",
        "Rettie", "Reuben", "Reva", "Rex", "Rey", "Reyes", "Reymundo", "Reyna", "Reynaldo", "Reynold",
        "Rhett", "Rhianna", "Rhoda", "Rhona", "Rhonda", "Ria", "Rian", "Riana", "Ricardo", "Ricci",
        "Ricco", "Rice", "Rich", "Richelle", "Richie", "Richmond", "Rick", "Rickey", "Ricki",
        "Rickie", "Ricky", "Rico", "Ridge", "Rigoberto", "Rikki", "Riley", "Rilla", "Rima", "Rina",
        "Rinaldo", "Ring", "Ringo", "Rita", "Ritchie", "River", "Riya", "Roald", "Rob", "Robb",
        "Robbie", "Robbin", "Robby", "Robbyn", "Roberta", "Roberto", "Robin", "Robinson", "Robt",
        "Robyn", "Rocco", "Rochelle", "Rock", "Rocky", "Rod", "Roderick", "Rodger", "Rodney", "Rodolfo",
        "Rodrick", "Rodrigo", "Roe", "Roel", "Roelof", "Rogan", "Rogers", "Roland", "Rolando",
        "Ludlow", "Luke", "Lusk", "Lyndal", "Lyndall", "Lynn", "Lynton", "Maddox", "Mallin",
        "Mander", "Mansfield", "Markham", "Marland", "Marley", "Marrock", "Marsh", "Marston", "Martin","Marvin", "Massey", "Matheson",
        "Maverick", "Maxwell", "Mayer", "Melborn", "Melbourne", "Melburn", "Meldon", "Melor", "Merrick",
        "Merton", "Miles", "Monte", "Montgomery", "Moreland", "Morley", "Morrison", "Myles", "Nagel",
        "Ned", "Nellie", "Nesbit", "Newbury", "Newt", "Nile", "Norman", "Norris", "Northcliff",
        "Northrop", "Norton","Ralphina", "Randi", "Raven", "Rayelle", "Rea", "Remington", "Richelle", "Ripley",
        "Robin", "Rosemary", "Rowan", "Rumer", "Ryesen", "Sable", "Sadie", "Saffron", "Saga",
        "Saige", "Salal", "Salia", "Sandora", "Sebille", "Sebrina", "Selby", "Serenity", "Shae",
        "Shandy", "Shanice", "Sharman", "Shelbi", "Sheldon", "Shelley", "Sheridan", "Sherill", "Sheryl",
        "Sheyla", "Shirley", "Shirlyn", "Silver", "Skyla", "Skylar", "Sorilbran", "Sparrow", "Spring",
        "Starleen", "Stockard", "Storm", "Sudie", "Summer",
        "Norvell", "Norvin", "Norwin", "Nuys", "Obsidian", "Octha", "Odell", "Odette",
        "Offa", "Orlan", "Ormond", "Orrick", "Orson", "Osborn", "Osgood", "Osric",
        "Ossie", "Overton", "Pacey", "Parsifal", "Peers", "Pelleas", "Pelton", "Penda",
        "Pierce", "Piers", "Powell", "Quirin", "Radbert", "Radford", "Radley", "Radnor",
        "Raine", "Randal", "Rawdan", "Rayce", "Reed", "Reynold", "Rhett", "Rhodes",
        "Ridge", "Ridgley", "Ris", "Rivalen", "Rivers", "Roan", "Robin",
        "Robson", "Rockleigh", "Sunniva", "Suzana", "Symphony", "Tacey", "Tahnee", "Taite", "Talon", "Tambre", "Tamia",
        "Taniya", "Tanner", "Tanzi", "Taria", "Tate", "Tatum", "Tawnie", "Taya", "Tayla",
        "Taylor", "Tayna", "Teddi", "Tena", "Tera", "Teri", "Teryl", "Thistle", "Timotha",
        "Tinble", "Tosha", "Gois", "Totie", "Traci", "Tru", "Trudie", "Trudy", "Tryamon", "Tuesday",
        "Twila", "Twyla", "Tyne", "Udele", "Unity", "Vail", "Vala", "Velvet", "Venetta",
        "Walker", "Wallis", "Waneta", "Waverly", "Wendy", "Rockwell", "Roden", "Roe", "Roldan",
        "Rosencrantz", "Ross", "Roswell", "Rowley", "Royce",
        "Rudd", "Rugby", "Rune", "Ryder", "Sadler", "Sage", "Salisbury", "Salter", "Sanborn",
        "Sandhurst", "Saxon", "Scarus", "Searles", "Seaton", "Sedgwick", "Seger", "Selby", "Seldon",
        "Selwyn", "Seton", "Severin", "Sewell", "Shade", "Shadow", "Shelby", "Sheldon", "Shepley",
        "Sherborn", "Sidwell", "Siler", "Simeon", "Siward", "Skye", "Slate", "Smith", "Somerby",
        "Somerton", "Sommar", "Spalding", "Spaulding", "Speers", "Weslee", "Whitley",
        "Whitney", "Whoopi", "Wilda", "Wilfreda", "Willow", "Wilona", "Winifred",
        "Winsome", "Winter", "Wisdom", "Wrenn", "Yale", "Yardley", "Yeardley", "Yedda", "Young",
        "Ysolde", "Zadie", "Zanda", "Zavannah", "Zavia", "Zeolia", "Zinnia",
        "Stafford", "Stamford", "Stanbury", "Stancliff", "Stanwick", "Starr", "Steadman", "Sterling",
        "Stetson", "Stiles", "Sting", "Stoke", "Storm", "Stuart", "Sunny", "Sydney",
        "Sylvester", "Taft", "Talon", "Tem", "Templeton", "Thompson", "Thorley", "Thorndike",
        "Tolbert", "Tyson", "Peep", "Udall", "Udel", "Udolf", "Ulland", "Ulmer",
        "Unten", "Unwin", "Upjohn", "Upton", "Upwood", "Usher", "Uther", "Vail",
        "Valen", "Verges", "Versey", "Vine", "Vinson", "Vinton", "Voltimand", "Vortigem",
        "Wadell", "Wadley",  "Wadsworth", "Wain", "Waite", "Walcott", "Wales", "Walford", "Walfred",
        "Walker", "Waller", "Walmir", "Walsh", "Walworth", "Walwyn", "Warburton", "Ward",
        "Warden", "Wardford", "Wardley", "Ware", "Waring", "Warley", "Warrick", "Warton",
        "Warwick", "Washburn", "Wat", "Watford", "Wayde", "Waylon", "Webb", "Welcome",
        "Weldon", "Westbrook", "Whistler", "Whitby", "Whitcomb", "Whittaker", "Wid", "Wiley",
        "Wilford", "Willow", "Wilton", "Wingy", "Wirt", "Wisdom", "Wissian", "Witton",
        "Wolcott", "Wolf", "Wolfe", "Woodis", "Woodson", "Wulfsige",
        "Wyclef", "Wynton", "Wynward", "Wyson", "Wythe", "Yardley", "Yeoman", "Yorath", "Yule", "Zani",
        "Abacate", "Dave", "Jc", "Ro","Miragem","Pal", "Chip"
    };

    private Names(){

    }

    public static Names getInstance(){
        if(!defined){
            instance = new Names();
            defined = true;
        }
        return instance;
    }
    
    @Override
    public String nextName(){
        CustomRandom random = RandomSingleton.getInstance();
        return names[(random.nextInt(names.length))];
    }
}