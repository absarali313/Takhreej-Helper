import pandas as pd
import string
import re
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.stem import PorterStemmer
from nltk.stem import WordNetLemmatizer
from gensim.models import Word2Vec
import pyarabic.araby as araby

def extract_text_between_quotes(text):
    # Define a regular expression to match text between double quotes
    pattern = r'"([^"]*)"'
    
    # Search for the pattern in the input text
    match = re.search(pattern, text)
    
    # If a match is found, extract the text between the quotes
    if match:
        return match.group(1)
    else:
        return ""

def preprocessing(text):
    text = extract_text_between_quotes(text)
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
    
