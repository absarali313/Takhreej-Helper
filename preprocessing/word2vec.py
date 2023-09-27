import pandas as pd
import string
import re
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from preprocess import preprocessing
from gensim.models import Word2Vec
df = pd.read_csv('C:\\Users\\ch-sa\\Downloads\\sanadset.csv')

# Access data from the 4th column
text_column = df['Matn']


cleaned_text = []
for i in range(20000):
    text = preprocessing(text_column[i])
   
    cleaned_text.append((text))

# Tokenize the cleaned text
tokenized_text = [word_tokenize(text) for text in cleaned_text]
print(tokenized_text)
# Train a Word2Vec model
model = Word2Vec(tokenized_text, vector_size=100, window=5, min_count=1, sg=1)

# Save the Word2Vec model
model.save("word2vec_model.model")

# Create a DataFrame to store word vectors
word_vectors = pd.DataFrame({word: model.wv[word] for word in model.wv.index_to_key})

# Save word vectors to a CSV file
word_vectors.to_csv("word_vectors.csv")