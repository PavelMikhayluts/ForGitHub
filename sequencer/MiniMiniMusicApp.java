package sequencer;

import javax.sound.midi.*;

public class MiniMiniMusicApp {

	public static void main(String[]args) {
		MiniMiniMusicApp mini=new MiniMiniMusicApp();
		mini.play();
	}
	
	public void play() {
		try {
		Sequencer player=MidiSystem.getSequencer();
		player.open(); //ѕолучаем синтезатор и открываем его чтобы начать использовать
		
		Sequence seq=new Sequence(Sequence.PPQ, 4);
		Track track=seq.createTrack();//запрашиваем трек у последовательности
		
		//ѕомещаем в трек MIDI событи€
		
		ShortMessage a=new ShortMessage();// —оздаем сообщение
		a.setMessage(144,1,44,100);//ѕомещаем в сообщение инструкцию
		MidiEvent noteOn=new MidiEvent(a, 1);//»спользу€ сообщение создаем новое событие
		//»нструкции хран€тс€ в сообщении,но MidiEvent дополн€ет их информацией о моменте времени, в который они должны
		// сработать. Ётот экземпл€р MidiEvent говорит о том что сообщение а сработает на первом такте. (бит 1)
		
		track.add(noteOn);// ƒобавл€ем событие в трек
		//“рек хранит все обьекты MidiEvent. ќни размещаютс€ в последовательности согласно времени срабатывани€,
		//а синтезатор проигрывает их в заданном пор€дке. ¬ один момент времени у вас может произойти множество
		// событий. Ќапример вам понадобитс€ проиграть одновременно 2 ноты или даже несколько звуков из разных 
		// инструментов.
		
		
		ShortMessage b=new ShortMessage();
		b.setMessage(128, 1,44,100);
		MidiEvent noteOff=new MidiEvent(b, 15);
		
		track.add(noteOff);
		
		//передаем последовательность синтезатору, как будто вставл€ем CD в проигрыатель
		
	    player.setSequence(seq);
	    
	    //запускаем синтезатор
	    
	    player.start();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		}
}
