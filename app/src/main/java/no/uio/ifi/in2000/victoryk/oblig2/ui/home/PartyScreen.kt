package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo


@Composable
fun PartyScreen(
    modifier: Modifier = Modifier,
    partyViewModel: PartyViewModel = PartyViewModel(),
    partyInfo: PartyInfo)
{
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column {
            // 1. Partinavn
            Text(text = partyInfo.name)

            // 2. Bilde
            AsyncImage(model = partyInfo.img, contentDescription = null)    // contentdescription som beskrivelse eller null?

            // 3. Leder
            Text(text = partyInfo.leader)

            var partyColor = Color.White
            // 4. Farge
            try {
                partyColor = Color(partyInfo.color.toInt())
            } catch (error: TypeNotPresentException) { // feil type exception?
                Log.e("ERROR", "Could not convert image String to Int")
            }

            ColorSpacer(modifier, partyColor)  // endres faktisk partyColor før den sendes med her nå? 

            // 5. Beskrivelse
            Text(text = partyInfo.description)

        }
    }
}

@Composable
fun ColorSpacer(modifier: Modifier = Modifier, partyColor: Color) {
    Column(modifier.fillMaxWidth().height(8.dp)) {
        Box(modifier = modifier.fillMaxSize().clip(RectangleShape).background(partyColor))
    }
}

