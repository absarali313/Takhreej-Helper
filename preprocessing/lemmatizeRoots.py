import mysql.connector
import qalsadi.lemmatizer
import string

def lemmatize_text(text):
    lemmatizer = qalsadi.lemmatizer.Lemmatizer()
    # Remove punctuation and split text into words
    words = text.translate(str.maketrans('', '', string.punctuation)).split()
    # Lemmatize words and filter out one-letter words
    lemmatized_words = [lemmatizer.lemmatize(word) for word in words if len(word) > 1]
    lemmatized_text = ' '.join(lemmatized_words)
    return lemmatized_text

def select_and_insert_hadith_with_lemmatization():
    try:
        # Connect to the MySQL database
        connection = mysql.connector.connect(
            host='localhost',
            database='fyp',
            user='root',
            password=''
        )

        if connection.is_connected():
            print("Connected to MySQL database")

            # Create a cursor object to execute SQL queries
            cursor = connection.cursor()

            # Define the SQL query to retrieve data from the 'hadith' table
            query = "SELECT * FROM hadith"

            # Execute the SQL query
            cursor.execute(query)

            # Fetch all rows of the result
            hadith_data = cursor.fetchall()

            # Prepare the insert query
            insert_query = "INSERT INTO hadithroots (hadithid, root) VALUES (%s, %s)"

            # Lemmatize matn column of each hadith and insert into hadithroot table
            for hadith in hadith_data:
                hadith_serial = hadith[0]
                matn = hadith[3]  # Assuming the matn is in the 4th column (index 3)
                lemmatized_text = lemmatize_text(matn)
                lemmatized_words = lemmatized_text.split()  # Split lemmatized text into words
                print(hadith_serial)
                # Create a list of tuples for batch insertion
                values = [(hadith_serial, word) for word in lemmatized_words]
                # Execute batch insertion
                cursor.executemany(insert_query, values)

            # Commit the changes
            connection.commit()
            print("Lemmatized words inserted into hadithroot table successfully.")

    except mysql.connector.Error as error:
        print("Error while connecting to MySQL database:", error)

    finally:
        if connection.is_connected():
            # Close cursor and connection
            cursor.close()
            connection.close()
            print("MySQL connection is closed")

# Call the function to retrieve hadith data and insert lemmatized words into hadithroot table
select_and_insert_hadith_with_lemmatization()
