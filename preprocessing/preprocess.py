import pandas as pd
import string
import re
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.stem import PorterStemmer
from nltk.stem import WordNetLemmatizer
from gensim.models import Word2Vec
import pyarabic.araby as araby




def preprocessing(text):
   # Step 1: Remove diacritics, shadda, madd, and additional punctuation
    text = araby.strip_diacritics(text)
    text = araby.strip_shadda(text)
    text = araby.strip_tatweel(text)
    text = re.sub(r'[،"\'\\‘’“”]', '', text)  # Remove comma, quotation marks, etc.
    

    # Step 2: Tokenization
    tokens = word_tokenize(text)

    # Step 3: Removing Punctuation
    cleaned_tokens = [word for word in tokens if word not in string.punctuation]

    # Step 4: Removing Stop Words
    stop_words = set(stopwords.words('arabic'))
    filtered_tokens = [word for word in cleaned_tokens if word.lower() not in stop_words]
    
    # Step 5: Stemming
    stemmer = PorterStemmer()
    stemmed_tokens = [stemmer.stem(word) for word in filtered_tokens]

    # Step 6: Lemmatization
    lemmatizer = WordNetLemmatizer()
    lemmatized_tokens = [lemmatizer.lemmatize(word) for word in stemmed_tokens]



    # Step 7: Removing HTML Tags
    cleaned_text = re.sub('<.*?>', '', ' '.join(lemmatized_tokens))

    # Step 8: Whitespace and Extra Spaces
    cleaned_text = ' '.join(cleaned_text.split())

    # Step 9: Handling Numerical Data (removing digits)
    cleaned_text = ''.join([word for word in cleaned_text if not word.isdigit()])
    return cleaned_text
    
df = pd.read_csv('C:\\Users\\ch-sa\\Downloads\\sanadset.csv')

# Access data from the 4th column
text_column = df['Matn']


cleaned_text = []
for i in range(2000):
    print(i)
    cleaned_text.append(preprocessing(text_column[i]))

# Tokenize the cleaned text
tokenized_text = [word_tokenize(text) for text in cleaned_text]

# Train a Word2Vec model
model = Word2Vec(tokenized_text, vector_size=100, window=5, min_count=1, sg=1)

# Save the Word2Vec model
model.save("word2vec_model.model")

# Create a DataFrame to store word vectors
word_vectors = pd.DataFrame({word: model.wv[word] for word in model.wv.index_to_key})

# Save word vectors to a CSV file
word_vectors.to_csv("word_vectors.csv")







   

