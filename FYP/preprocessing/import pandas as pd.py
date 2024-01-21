from gensim.models import Word2Vec

# Load the Word2Vec model
model = Word2Vec.load("word2vec_model.model")

# Example 1: Accessing word vectors
word_vector = model.wv['النبي']
print("Word Vector for 'النبي':", word_vector)

# Example 2: Finding similar words
similar_words = model.wv.most_similar('النبي', topn=5)
print("Most similar words to 'النبي':", similar_words)

