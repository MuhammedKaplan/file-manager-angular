print('Starting creating database #######################');

db = db.getSiblingDB('fmdb');
db.createUser(
    {
        user: 'fmdb',
        pwd: 'pwd',
        roles : [{role: 'readWrite', db: 'fmdb'}]
    }
);

// new mongo connection
conn = new Mongo();

// get the database
db = conn.getDB('fmdb');

// create the collection
db.users.insert({ "username": "admin", "password": "admin" });

// End of script
print('Database created #######################');