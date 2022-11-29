print("Started Adding the Users.");
db = db.getSiblingDB("admin");
db.createUser({
  user: "testuser",
  pwd: "testpass",
  roles: [{ role: "readWrite", db: "admin" }],
});
print("End Adding the User Roles.");