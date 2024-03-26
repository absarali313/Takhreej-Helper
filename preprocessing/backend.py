from flask import Flask, request, jsonify
import qalsadi.lemmatizer
import openai

app = Flask(__name__)

@app.route('/lemmatize', methods=['POST'])
def lemmatize():
    text = request.json.get('text', '')
    lemmatizer = qalsadi.lemmatizer.Lemmatizer()
    lemmatized_words = [lemmatizer.lemmatize(word) for word in text.split()]
    lemmatized_text = ' '.join(lemmatized_words)
    return jsonify({'lemmatized_text': lemmatized_text})

def get_topic(hadith):
    user_message = "Tell me 3 one word topics [ maximum 5] in Arabic for the following Hadith,give the topic with easiest synonym, give shortest words for topic after removing all prefix and suffix,only reply with topics separated by one comma, be specific and dont use any english" + hadith
    openai.api_key = api_key

    # Retry up to 3 times if the initial response takes longer than 3 seconds
    for _ in range(3):
        try:
            response =openai.chat.completions.create(
                model="gpt-3.5-turbo-0125",
                messages=[{"role": "user", "content": user_message}],
                temperature=1,
                max_tokens=1024,
                top_p=1,
                frequency_penalty=0,
                presence_penalty=0
            )
            return lemmatize(response.choices[0].message.content)
        except openai.error.OpenAIError:
            time.sleep(3)  # Wait for 1 second before retrying

    return "Unable to retrieve a timely response. Please try again later."

def lemmatize(text):
    lemmatizer = qalsadi.lemmatizer.Lemmatizer()
    lemmatized_words = [lemmatizer.lemmatize(word) for word in text.split()]
    lemmatized_text = ','.join(lemmatized_words)
    return lemmatized_text

@app.route('/get_topic', methods=['POST'])
def predict_topic():
    hadith = request.json.get('hadith')
    if not hadith:
        return jsonify({'error': 'Hadith not provided'}), 400

    topic = get_topic(hadith)
    return jsonify({'topic': topic})



def translate(hadith):
    
    user_message = "Translate this hadith into english : " + hadith
    openai.api_key = api_key

    # Retry up to 3 times if the initial response takes longer than 3 seconds
    for _ in range(5):
        
        response =openai.chat.completions.create(
            messages=[{"role": "user", "content": user_message}],
            temperature=1,
            max_tokens=1024,
            model="gpt-3.5-turbo-0125",
            top_p=1,
            frequency_penalty=0,
            presence_penalty=0
            )
        return (response.choices[0].message.content)
       

    return "Unable to retrieve a timely response. Please try again later."

@app.route('/translate', methods=['POST'])
def get_translation():
    hadith = request.json.get('hadith')
    if not hadith:
        return jsonify({'error': 'Hadith not provided'}), 400

    new_hadith = translate(hadith)
    return jsonify({'translation': new_hadith})

if __name__ == '__main__':
    app.run(debug=True)