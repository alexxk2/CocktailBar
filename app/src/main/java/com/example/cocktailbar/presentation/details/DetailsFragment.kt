package com.example.cocktailbar.presentation.details

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.cocktailbar.R
import com.example.cocktailbar.databinding.FragmentDetailsBinding
import com.example.cocktailbar.domain.models.Cocktail


class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var cocktail: Cocktail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cocktail = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelable(COCKTAIL, Cocktail::class.java)!!
            } else it.getParcelable(COCKTAIL)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding){

            Glide.with(requireContext())
                .load(R.drawable.mohito_image)
                .centerCrop()
                .into(cocktailImage)

            cocktailTitle.text = cocktail.name
            cocktailDescription.text = cocktail.description
            cocktailIngredients.text = cocktail.ingredients
            cocktailRecipe.text = getString(R.string.recipe_string, cocktail.recipe)
        }

        binding.buttonEdit.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToCreationFragment(cocktail.id)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        const val COCKTAIL = "cocktail"
    }
}