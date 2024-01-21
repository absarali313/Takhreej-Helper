import pandas as pd
import mysql.connector
import string

# Function to remove punctuation, <IDF></IDF> and English letters
def clean_value(value):
    # Remove punctuation (except comma)
    value = ''.join(char for char in value if char not in string.punctuation or char == ',')

    # Remove <IDF></IDF>
    value = value.replace('<IDF>', '').replace('</IDF>', '')

    # Remove English letters
    value = ''.join(char for char in value if char not in 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ')

    return value

# Replace these with your database credentials
host = "localhost"
user = "root"
password = ""
database = "fyp"

# CSV file path and name
csv_file_path = "bhukarinew (1).csv"

# Connect to the MySQL server
conn = mysql.connector.connect(
    host=host,
    user=user,
    password=password,
    database=database
)

# Create a cursor object to interact with the database
cursor = conn.cursor()

# Prepare the SQL query to check if the name already exists
check_query = "SELECT id FROM narrator WHERE name = %s"

# Prepare the SQL query to insert data into the 'narrator' table with IGNORE
insert_query = "INSERT  INTO sanad (narratorId,hadithId) VALUES (%s,%s)"

# Read the CSV file into a pandas DataFrame
df = pd.read_csv(csv_file_path, encoding='utf-8')

# Get the "Sanad" column from the DataFrame
sanad_column = df['Sanad']
i = 1
# Iterate through the "Sanad" column, clean the values, split by comma, and insert data into the database
for sanad_value in sanad_column:
    # Clean the value
    cleaned_value = clean_value(sanad_value)

    # Split by comma
    sanad_values = cleaned_value.split(',')
    
    # Iterate through the split values and insert each into the database if it doesn't already exist
    for value in sanad_values:
        cleaned_value = value.strip()
        if cleaned_value:
            
            cursor.execute(check_query, (cleaned_value,))
            id = cursor.fetchone()[0]

            # If the name doesn't exist, insert it
            
            cursor.execute(insert_query, (id,i,))
    i = i+1
# Commit the changes to the database
conn.commit()

# Close the cursor and connection
cursor.close()
conn.close()

print("Data inserted successfully!")
