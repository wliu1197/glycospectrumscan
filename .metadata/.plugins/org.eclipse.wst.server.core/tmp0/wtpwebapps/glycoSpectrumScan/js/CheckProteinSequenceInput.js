function CheckProteinSequenceInput(form)
	{
		var count=0;
		for (var i = 0; i < form.elements.length; i++) {
			if( form.elements[i].name == "ProteinSequence"){
				var value = form.elements[i].value;
				if(value==""){
					alert("No value entered in ProteinSequence." );
					return false;
				}
			/*	
				else if ( value.indexOf('b') != -1 || value.indexOf('B') != -1 ) {
					alert("Can't have value of b or B" );
					return false;	
				}else if ( value.indexOf('j') != -1 || value.indexOf('J') != -1 ) {
					alert("Can't have value of j or J" );
					return false;	
				}else if ( value.indexOf('x') != -1 || value.indexOf('X') != -1 ) {
					alert("Can't have value of x or X" );
					return false;	
				}else if ( value.indexOf('z') != -1 || value.indexOf('Z') != -1 ) {
					alert("Can't have value of z or Z" );
					return false;	
				}
			*/
			}
		
		}
		
	}