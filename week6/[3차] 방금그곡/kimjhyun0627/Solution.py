def solution(m, musicinfos):

    answer = '(None)'
    m = m.replace("A#", "!").replace("C#", "@").replace("D#", "#").replace("F#", "$").replace("G#", "%")
    time = 0

    for info in musicinfos:

        start, end, title, melody = info.split(",")
        start = start.split(":")
        end = end.split(":")
        duration = (int(end[0]) - int(start[0])) * 60 + int(end[1]) - int(start[1])
        melody = melody.replace("A#", "!").replace("C#", "@").replace("D#", "#").replace("F#", "$").replace("G#", "%")
        melody = melody * (duration // len(melody)) + melody[:duration % len(melody)]

        if m in melody and duration > time:
            time = duration
            answer = title

    return answer
