/**
 * 
 */

function fprint() {
	// id = id 인 요소를 접근, 값을 가져온다.
	idvalue = document.querySelector('#id').value;
	// 처리 
	str = "당신이 입력 한 id = " + idvalue + "입니다.";
	// 출력 장소 접근 - 내용을 출력한다. 
	document.querySelector('#result').innerText = str;
}