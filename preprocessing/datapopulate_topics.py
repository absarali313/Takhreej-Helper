import pandas as pd
import mysql.connector

# Read the CSV file into a DataFrame
df = pd.read_csv('C:/Users/ch-sa/Downloads/final_final.csv')


# Connect to MySQL database
cnx = mysql.connector.connect(
    host='localhost',
    user='root',
    password='',
    database='fyp'
)
cursor = cnx.cursor()

# Insert topics into MySQL table
for idx, topics_entry in enumerate(df['Topics'], start=1):
    topics = [topic.strip() for topic in topics_entry.split(',')]
    for topic in topics:
        add_topic = ("INSERT INTO hadithtopics (hadithId, topic) VALUES (%s, %s)")
        data_topic = (idx, topic)
        cursor.execute(add_topic, data_topic)

# Commit the changes and close the connection
cnx.commit()
cursor.close()
cnx.close()

print("Topics inserted into the 'hadithtopics' table successfully.")
