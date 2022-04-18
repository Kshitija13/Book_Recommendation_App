import pandas as pd
#load the data
from os.path import dirname,join
filename = join(dirname(__file__), "book.csv")

##Step 1: Read CSV File
book_data = pd.read_csv(filename)
book_data.head()
book_data['description'].head(20)
from sklearn.feature_extraction.text import TfidfVectorizer
tfidf_vector = TfidfVectorizer(stop_words='english')
book_data['description'] = book_data['description'].fillna('')
tfidf_matrix = tfidf_vector.fit_transform(book_data['description'])
from sklearn.metrics.pairwise import linear_kernel
sim_matrix = linear_kernel(tfidf_matrix, tfidf_matrix)
indices = pd.Series(book_data.index, index=book_data['title']).drop_duplicates()
indices[:10]
def content_based_recommender(title, sim_scores=sim_matrix):
    idx = indices[title]
    sim_scores = list(enumerate(sim_matrix[idx]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[1:2]
    movie_indices = [i[0] for i in sim_scores]
    return book_data['title'].iloc[movie_indices]

