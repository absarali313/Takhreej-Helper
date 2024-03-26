import openai
import qalsadi.lemmatizer
import time

def lemma(text):
    lemmatizer = qalsadi.lemmatizer.Lemmatizer()
    lemmatized_words = [lemmatizer.lemmatize(word) for word in text.split()]
    lemmatized_text = ','.join(lemmatized_words)
    return lemmatized_text
def get_topic(hadith):

    user_message = "Tell me 3 one word topics in Arabic for the following Hadith, only reply with topics separated by commas, in Arabic: " + hadith
    openai.api_key = api_key

    # Retry up to 3 times if the initial response takes longer than 3 seconds
    for _ in range(3):
        try:
            response =openai.chat.completions.create(
                model="gpt-3.5-turbo",
                messages=[{"role": "user", "content": user_message}],
                temperature=1,
                max_tokens=1024,
                top_p=1,
                frequency_penalty=0,
                presence_penalty=0
            )
            return lemma(response.choices[0].message.content)
        except openai.error.OpenAIError:
            time.sleep(3)  # Wait for 1 second before retrying

    return "Unable to retrieve a timely response. Please try again later."

hadith = '  , قَالَ : " غَزَا مَعَ رَسُولِ الله صَلَّي اللهُ عَلَيْهِ وَسَلَّمَ سِتَّ عَشْرَةَ غَزْوَةً "  .'
print(get_topic(hadith))
