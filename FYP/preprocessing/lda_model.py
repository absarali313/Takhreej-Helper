from gensim.models import Word2Vec
from gensim.models import LdaModel
from gensim.models import CoherenceModel
import gensim.corpora as corpora
import pandas as pd
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from preprocess import preprocessing
import re


# Load your pre-trained Word2Vec model
word2vec_model = Word2Vec.load('C:\\Users\\ch-sa\\OneDrive\\Desktop\\FYP\\word2vec_model.model')

# Prepare your Hadith data (a list of lists of words)
df = pd.read_csv('C:\\Users\\ch-sa\\Downloads\\sanadset.csv')

# Access data from the 4th column
text_column = df['Matn']

hadiths = []
for i in range(1000):
    print(i)
    text = preprocessing(text_column[i])
    hadiths.append(text)

# Assuming 'hadith_vectors' is a list of lists where each inner list represents a vectorized Hadith
hadith_vectors = []

for hadith in hadiths:
    tokenze = word_tokenize(hadith)
    print(hadith)
    vector = []
    for word in tokenze:
        if word in word2vec_model.wv:
            vector.append(word)
    hadith_vectors.append(vector)

# Now 'hadith_vectors' is a list of lists, and you can pass it to 'corpora.Dictionary()' without issues
dictionary = corpora.Dictionary(hadith_vectors)

# Create a document-term matrix
corpus = [dictionary.doc2bow(vector) for vector in hadith_vectors]
   
# Build the LDA model
lda_model = LdaModel(corpus, num_topics=1000, id2word=dictionary, passes=15)

lda_model.print_topics()


# Example: New Hadith or Document Text
new_hadith =  '  رَضِيَ اللَّهُ عَنْهُ عَلَى الْمِنْبَرِ ، قَالَ : سَمِعْتُ رَسُولَ اللَّهِ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ ، يَقُولُ : " إِنَّمَا الْأَعْمَالُ بِالنِّيَّاتِ ، وَإِنَّمَا لِكُلِّ امْرِئٍ مَا نَوَى ، فَمَنْ كَانَتْ هِجْرَتُهُ إِلَى دُنْيَا يُصِيبُهَا أَوْ إِلَى امْرَأَةٍ يَنْكِحُهَا ، فَهِجْرَتُهُ إِلَى مَا هَاجَرَ إِلَيْهِ "  .'


# Preprocess the new Hadith text
preprocessed_text = preprocessing(new_hadith)
print(preprocessed_text)
# Assuming 'dictionary' is the same dictionary used during LDA model training
# Convert the preprocessed text to a Bag of Words (BoW) representation
vector = dictionary.doc2bow(preprocessed_text.split())

# Get the topic distribution for the new Hadith
topic_distribution = lda_model[vector]
lda_model.save("lda_model.model")
# Determine the dominant topic for the new Hadith
dominant_topic = max(topic_distribution, key=lambda item: item[1])

# Print the dominant topic and its keywords
print(f"Dominant Topic ID: {dominant_topic[0]}")
print(f"Dominant Topic Keywords: {lda_model.print_topic(dominant_topic[0])}")

  