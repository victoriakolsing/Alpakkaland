package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import no.uio.ifi.in2000.victoryk.oblig2.Blush
import no.uio.ifi.in2000.victoryk.oblig2.SuperLightPink

@Composable
fun VoteList(
    viewModel: HomeViewModel,
    district: String
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(color = SuperLightPink, shape = RoundedCornerShape(10.dp))

    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(
                text = "Party",
                fontWeight = FontWeight.Bold,
                color = Blush
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Votes",
                fontWeight = FontWeight.Bold,
                color = Blush
            )

        }
    }
}
