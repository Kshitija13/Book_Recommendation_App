import pandas as pd
import numpy as np
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity
###### helper functions. Use them when needed #######
def get_title_from_index(index):
	return df[df.index == index]["title"].values[0]

def get_index_from_title(title):
	return df[df.title == title]["index"].values[0]
##################################################


from os.path import dirname,join
##Step 1: Read CSV File
filename = join(dirname(_file_), "book.csv")

##Step 1: Read CSV File
df = pd.read_csv(filename)

#print df.columns
#Step 2: Select Features

features = ['author','description','publisher','generes']
##Step 3: Create a column in DF which combines all selected features
for feature in features:
	df[feature] = df[feature].fillna('')

def combine_features(row):
	try:
		return row['author']+" "+row['description']+" "+row['publisher']+" "+row['generes']
	except:
		print("Error:"), row

def read_book(book_user_likes):

	df["combined_features"] = df.apply(combine_features, axis=1)

	# print "Combined Features:", df["combined_features"].head()

	##Step 4: Create count matrix from this new combined column
	cv = CountVectorizer()

	count_matrix = cv.fit_transform(df["combined_features"])

	##Step 5: Compute the Cosine Similarity based on the count_matrix
	cosine_sim = cosine_similarity(count_matrix)

	## Step 6: Get index of this movie from its title
	book_index = get_index_from_title(book_user_likes)

	similar_books = list(enumerate(cosine_sim[book_index]))

	## Step 7: Get a list of similar movies in descending order of similarity score
	sorted_similar_books = sorted(similar_books, key=lambda x: x[1], reverse=True)

	## Step 8: Print titles of first 20 movies
	i = 0
	arr=[]
	for element in sorted_similar_books:
	    t=get_title_from_index(element[0])
	    if t!=book_user_likes:
		    return t


##book_user_likes1 = input('Enter book : ')
##arr1 = read_book(book_user_likes1)
##print(*arr1, sep='\n')